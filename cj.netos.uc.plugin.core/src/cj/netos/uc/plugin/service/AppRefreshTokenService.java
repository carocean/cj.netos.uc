package cj.netos.uc.plugin.service;

import cj.netos.uc.model.AppAccessTokenExample;
import cj.netos.uc.model.AppRefreshToken;
import cj.netos.uc.model.AppRefreshTokenExample;
import cj.netos.uc.plugin.mapper.AppRefreshTokenMapper;
import cj.netos.uc.service.IAppRefreshTokenService;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;
import java.util.UUID;

@CjBridge(aspects = "@transaction")
@CjService(name = "appRefreshTokenService")
public class AppRefreshTokenService implements IAppRefreshTokenService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.AppRefreshTokenMapper")
    AppRefreshTokenMapper appRefreshTokenMapper;

    @CjTransaction
    @Override
    public AppRefreshToken updateRefreshToken(String person, String device) {
        AppRefreshToken appRefreshToken = appRefreshTokenMapper.selectByPrimaryKey(person, device);
        String refreshToken = Encript.md5(String.format("%s%s%s", person, device, UUID.randomUUID()));
        long pubTime = System.currentTimeMillis();
        if (appRefreshToken == null) {
            appRefreshToken = new AppRefreshToken();
            appRefreshToken.setPerson(person);
            appRefreshToken.setDevice(device);
            appRefreshToken.setRefreshToken(refreshToken);
            appRefreshToken.setPubTime(pubTime);
            appRefreshTokenMapper.insertSelective(appRefreshToken);
            return appRefreshToken;
        }
        appRefreshToken.setPubTime(pubTime);
        appRefreshToken.setRefreshToken(refreshToken);
        appRefreshToken.setDevice(device);
        appRefreshToken.setPerson(person);
        appRefreshTokenMapper.updateByPrimaryKey(appRefreshToken);
        return appRefreshToken;
    }

    @CjTransaction
    @Override
    public AppRefreshToken getRefreshToken(String refreshToken) {
        AppRefreshTokenExample example = new AppRefreshTokenExample();
        example.createCriteria().andRefreshTokenEqualTo(refreshToken);
        List<AppRefreshToken> list = this.appRefreshTokenMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @CjTransaction
    @Override
    public void updateDevice(String principal, String oldDevice, String newDevice) {
        AppRefreshTokenExample example = new AppRefreshTokenExample();
        example.createCriteria().andPersonEqualTo(principal).andDeviceNotEqualTo(oldDevice);
        appRefreshTokenMapper.deleteByExample(example);
        appRefreshTokenMapper.updateDevice(principal, oldDevice, newDevice);
    }
}
