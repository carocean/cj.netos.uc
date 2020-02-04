package cj.netos.uc.plugin.service;

import cj.netos.uc.model.AppRefreshToken;
import cj.netos.uc.model.AppRefreshTokenExample;
import cj.netos.uc.plugin.mapper.AppRefreshTokenMapper;
import cj.netos.uc.service.IAppRefreshTokenService;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

import java.util.List;
import java.util.UUID;
@CjService(name = "appRefreshTokenService")
public class AppRefreshTokenService implements IAppRefreshTokenService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.AppRefreshTokenMapper")
    AppRefreshTokenMapper appRefreshTokenMapper;

    @Override
    public AppRefreshToken updateRefreshToken(String person) {
        AppRefreshToken appRefreshToken = appRefreshTokenMapper.selectByPrimaryKey(person);
        String refreshToken= Encript.md5(String.format("%s%s",person, UUID.randomUUID()));
        long pubTime=System.currentTimeMillis();
        if (appRefreshToken == null) {
            appRefreshToken = new AppRefreshToken();
            appRefreshToken.setPerson(person);

            appRefreshToken.setRefreshToken(refreshToken);
            appRefreshToken.setPubTime(pubTime);
            appRefreshTokenMapper.insertSelective(appRefreshToken);
            return appRefreshToken;
        }
        appRefreshToken.setPubTime(pubTime);
        appRefreshToken.setRefreshToken(refreshToken);
        appRefreshToken.setPerson(person);
        appRefreshTokenMapper.updateByPrimaryKey(appRefreshToken);
        return appRefreshToken;
    }

    @Override
    public AppRefreshToken getRefreshToken(String refreshToken) {
        AppRefreshTokenExample example=new AppRefreshTokenExample();
        example.createCriteria().andRefreshTokenEqualTo(refreshToken);
        List<AppRefreshToken> list=this.appRefreshTokenMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
