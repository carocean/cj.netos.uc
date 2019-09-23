package cj.netos.uc;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.service.IKeyStore;
import cj.netos.uc.util.JwtUtil;
import cj.studio.ecm.IServiceSite;
import cj.studio.openport.CheckTokenException;
import cj.studio.openport.ICheckTokenStrategy;
import cj.studio.openport.TokenInfo;
import cj.studio.openport.annotations.CjOpenport;
import io.jsonwebtoken.Claims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckTokenStrategy implements ICheckTokenStrategy {
    IKeyStore keyStore;
    @Override
    public void init(IServiceSite site) {
        keyStore=(IKeyStore)site.getService("ucplugin.keyStore");
    }

    @Override
    public TokenInfo checkToken(String portsurl, String methodName, CjOpenport openport, String token) throws CheckTokenException {
        Claims claims =JwtUtil.parseJWT(token,keyStore.getKey());
        TokenInfo tokenInfo=new TokenInfo();
        tokenInfo.setUser(claims.getSubject());
        tokenInfo.getProps().putAll(claims);
        //uc的api使用的仅仅是uc角色，租户角色和应用角色可弃之不用
        List<Map<String,String>> roles=(List<Map<String,String>>)claims.get("uc-roles");
        List<String> sroles=new ArrayList<>();
        for(Map<String,String> role:roles){
            sroles.add(role.get("roleId"));
        }
        tokenInfo.getRoles().addAll(sroles);
        return tokenInfo;
    }
}
