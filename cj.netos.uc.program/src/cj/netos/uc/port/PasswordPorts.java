package cj.netos.uc.port;

import cj.netos.uc.service.IAppRoleService;
import cj.netos.uc.service.IPasswordService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "/password")
public class PasswordPorts implements IPasswordPort {
    @CjServiceRef(refByName = "ucplugin.passwordService")
    IPasswordService passwordService;

    @Override
    public void updatePassword(String appid, String accountName, String oldpwd, String newpwd) throws CircuitException {
        passwordService.updatePassword(appid, accountName, oldpwd, newpwd);
    }
}
