package cj.netos.uc;

import cj.netos.uc.service.IKeyStore;
import cj.netos.uc.util.JwtUtil;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.CheckAccessTokenException;
import cj.studio.openport.DefaultSecuritySession;
import cj.studio.openport.ICheckAccessTokenStrategy;
import cj.studio.openport.ISecuritySession;
import io.jsonwebtoken.Claims;

import java.util.List;
import java.util.Map;

public class UcCheckAccessTokenStrategy implements ICheckAccessTokenStrategy {
    IKeyStore keyStore;
    @Override
    public void init(IServiceSite site) {
        keyStore=(IKeyStore)site.getService("ucplugin.keyStore");
    }

    @Override
    public ISecuritySession checkAccessToken(String portsurl, String methodName, String accessToken) throws CheckAccessTokenException {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(accessToken,keyStore.getKey());
        } catch (CircuitException e) {
            throw new CheckAccessTokenException(e.getStatus(),e.getMessage());
        }
        ISecuritySession securitySession=new DefaultSecuritySession(claims.getSubject());
        //uc的api使用的仅仅是uc角色，租户角色和应用角色可弃之不用
        List<Map<String,String>> roles=(List<Map<String,String>>)claims.get("uc-roles");
        for(Map<String,String> role:roles){
            securitySession.addRole(role.get("roleId"));
        }
        return securitySession;
    }

}
