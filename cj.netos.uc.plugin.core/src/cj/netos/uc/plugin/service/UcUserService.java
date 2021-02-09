package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.UcUserMapper;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IUcEmployeeService;
import cj.netos.uc.service.IUcUserService;
import cj.netos.uc.util.NumberGen;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IServiceAfter;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceInvertInjection;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "ucUserService")
public class UcUserService implements IUcUserService, IServiceAfter {
    OkHttpClient client;
    String wechatAppid;
    String wechatAppSecret;
    String wechatWebid;
    String wechatWebSecret;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UcUserMapper")
    UcUserMapper userMapper;

    @CjServiceInvertInjection
    @CjServiceRef(refByName = "appAccountService")
    IAppAccountService appAccountService;

    @CjServiceRef
    IUcEmployeeService ucEmployeeService;

    @CjTransaction
    @Override
    public void onAfter(IServiceSite site) {
        wechatAppid = site.getProperty("wechat.appid");
        wechatAppSecret = site.getProperty("wechat.appSecret");
        wechatWebid = site.getProperty("wechat.webid");
        wechatWebSecret = site.getProperty("wechat.webSecret");
        client = new OkHttpClient();
    }

    @CjTransaction
    @Override
    public String addUser(String uid, String realName, String sex, String email, String mobile, String idcard) throws CircuitException {
        if (StringUtil.isEmpty(realName)) {
            throw new CircuitException("404", "真实名为空");
        }
        UcUser ucUser = new UcUser();
        ucUser.setUserId(StringUtil.isEmpty(uid) ? NumberGen.gen() : uid);
        ucUser.setCreateTime(new Date());
        ucUser.setRealName(realName);
        ucUser.setEmail(email);
        ucUser.setIdcard(idcard);
        ucUser.setMobile(mobile);
        ucUser.setSex(sex);
        userMapper.insertSelective(ucUser);
        return ucUser.getUserId();
    }

    @CjTransaction
    @Override
    public long getUserCount() throws CircuitException {
        UcUserExample example = new UcUserExample();
        return userMapper.countByExample(example);
    }

    @CjTransaction
    @Override
    public List<UcUser> pageUser(int currPage, int pageSize) throws CircuitException {
        return userMapper.pageUser(currPage, pageSize);
    }

    @CjTransaction
    @Override
    public UcUser registerByPassword(String appid, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(accountCode)) {
            throw new CircuitException("404", "账户名为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setRealName(accountCode);
        user.setUserId(NumberGen.gen());
        userMapper.insert(user);

        this.appAccountService.addAccount(accountCode, (byte) 0, user.getUserId(), appid, password, nickName, avatar, signature);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByIphone(String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(phone)) {
            throw new CircuitException("404", "手机号为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setRealName(phone);
        user.setUserId(NumberGen.gen());
        user.setMobile(phone);
        userMapper.insert(user);

        this.appAccountService.addAccount(phone, (byte) 1, user.getUserId(), appid, password, nickName, avatar, signature);
        return user;
    }

    @CjTransaction
    @Override
    public UcUser registerByEmail(String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        if (StringUtil.isEmpty(appid)) {
            throw new CircuitException("404", "应用标识为空");
        }
        if (StringUtil.isEmpty(email)) {
            throw new CircuitException("404", "邮箱为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new CircuitException("404", "密码为空");
        }

        UcUser user = new UcUser();
        user.setCreateTime(new Date());
        user.setRealName(email);
        user.setUserId(NumberGen.gen());
        user.setEmail(email);
        userMapper.insert(user);

        this.appAccountService.addAccount(email, (byte) 2, user.getUserId(), appid, password, nickName, avatar, signature);
        return user;
    }

    @CjTransaction
    @Override
    public AppAccount registerByWeChat(String appid, String state, String code, String deviceType) throws CircuitException {
        if (StringUtil.isEmpty(code)) {
            throw new CircuitException("404", "code为空");
        }
        CJSystem.logging().info(getClass(), String.format("微信转发来的验证信息：%s %s", state, code));
        //注意：如果用户选了"拒绝"而执行以下代码获取令牌，则下次就不会弹出微信的授权页了。
        String useAppid=wechatAppid;
        String useSecret=wechatAppSecret;
        if ("web".equals(deviceType)) {
            useAppid=wechatWebid;
            useSecret=wechatWebSecret;
        }
//        CJSystem.logging().info(getClass(),String.format("type:%s %s %s",deviceType,useAppid,useSecret));
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", useAppid, useSecret, code);
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .get()//默认就是GET请求，可以不写
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();
            String json = response.body().string();
            Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
            CJSystem.logging().info(getClass(), String.format("微信令牌返回:%s", map));
            String accessToken = (String) map.get("access_token");
            String unionid = (String) map.get("unionid");
            if (StringUtil.isEmpty(unionid)) {
                throw new CircuitException("500","微信验证失败。未得到微信用户统一标识");
            }
            String openid = (String) map.get("openid");
            AppAccount appAccount = appAccountService.getAccountByCode(appid, unionid);
            if (appAccount != null) {
                return appAccount;
            }

            WechatUserInfo userInfo = getUserInfo(accessToken, openid);
            UcUser user = new UcUser();
            user.setCreateTime(new Date());
            user.setRealName(userInfo.getNickname());
            user.setUserId(NumberGen.gen());
            String sex = "unknown";
            switch (userInfo.getSex()) {
                case 1:
                    sex = "male";
                    break;
                case 2:
                    sex = "female";
                    break;
            }
            user.setSex(sex);

            userMapper.insert(user);

            this.appAccountService.addAccount(userInfo.getUnionid(), (byte) 3, user.getUserId(), appid, code, userInfo.getNickname(), userInfo.getHeadimgurl(), null);
            appAccount = appAccountService.getAccountByCode(appid, unionid);
            return appAccount;
        } catch (Exception e) {
            CircuitException ce = CircuitException.search(e);
            if (ce != null) {
                throw ce;
            }
            throw new CircuitException("500", e);
        }
    }

    private WechatUserInfo getUserInfo(String accessToken, String openid) throws IOException {
        String url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, openid);
        Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        CJSystem.logging().info(getClass(), String.format("-----这是微信返回：%s", json));
        WechatUserInfo userInfo = new Gson().fromJson(json, WechatUserInfo.class);
        return userInfo;
    }

    @CjTransaction
    @Override
    public UcUser getUserById(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }


    @CjTransaction
    @Override
    public void updateProfile(String uid, UcUser user) {
        user.setUserId(uid);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @CjTransaction
    @Override
    public void updateRealName(String userId, String realName) throws CircuitException {
        userMapper.updateRealName(userId, realName);
    }

    @CjTransaction
    @Override
    public void updateSex(String userId, String sex) {
        userMapper.updateSex(userId, sex);
    }

    @CjTransaction
    @Override
    public boolean isEmployee(String uid) throws CircuitException {
        return !ucEmployeeService.listMyEmployee(uid).isEmpty();
    }
}
