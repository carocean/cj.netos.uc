package cj.netos.uc.port;

import cj.netos.uc.model.UcUser;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

@CjService(name = "/register.service")
public class RegisterAccountPort implements IRegisterAccountPort {
    @Override
    public UcUser registerByPassword(ISecuritySession securitySession, String accountCode, String password, String nickName, String avatar, String signature) throws CircuitException {
        return null;
    }

    @Override
    public UcUser registerByIphone(ISecuritySession securitySession, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        return null;
    }

    @Override
    public UcUser registerByEmail(ISecuritySession securitySession, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        return null;
    }
}
