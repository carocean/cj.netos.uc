package cj.netos.uc.port;

import cj.netos.uc.model.UcUser;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

@CjService(name = "/register.service")
public class RegisterAccountPort implements IRegisterAccountPort {
    @CjServiceRef(refByName = "ucplugin.ucUserService")
    IUcUserService ucUserService;
    @Override
    public UcUser registerByPassword(ISecuritySession securitySession, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        return ucUserService.registerByPassword(securitySession.principal(),accountCode,password,nickName,avatar,signature);
    }

    @Override
    public UcUser registerByIphone(ISecuritySession securitySession, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        return ucUserService.registerByIphone(securitySession.principal(),phone,password,nickName,avatar,signature);
    }

    @Override
    public UcUser registerByEmail(ISecuritySession securitySession, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        return ucUserService.registerByEmail(securitySession.principal(),email,password,nickName,avatar,signature);
    }
}
