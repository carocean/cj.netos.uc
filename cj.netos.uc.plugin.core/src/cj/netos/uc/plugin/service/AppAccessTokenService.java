package cj.netos.uc.plugin.service;

import cj.netos.uc.model.AppAccessToken;
import cj.netos.uc.model.AppAccessTokenExample;
import cj.netos.uc.plugin.mapper.AppAccessTokenMapper;
import cj.netos.uc.service.IAppAccessTokenService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjService(name = "appAccessTokenService")
public class AppAccessTokenService implements IAppAccessTokenService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.AppAccessTokenMapper")
    AppAccessTokenMapper appAccessTokenMapper;

    @CjTransaction
    @Override
    public AppAccessToken getAccessToken(String accessToken) {
        AppAccessTokenExample example = new AppAccessTokenExample();
        example.createCriteria().andAccessTokenEqualTo(accessToken);
        List<AppAccessToken> list = appAccessTokenMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @CjTransaction
    @Override
    public void updateAccessToken(String person,String device, AppAccessToken appAccessToken) {
        AppAccessToken token = appAccessTokenMapper.selectByPrimaryKey(person,device);
        if (token == null) {
            appAccessTokenMapper.insertSelective(appAccessToken);
            return;
        }
        if (StringUtil.isEmpty(appAccessToken.getPerson())) {
            appAccessToken.setPerson(person);
        }
        if (StringUtil.isEmpty(appAccessToken.getDevice())) {
            appAccessToken.setDevice(device);
        }
        this.appAccessTokenMapper.updateByPrimaryKeySelective(appAccessToken);
    }
}
