package cj.netos.uc.port;

import cj.netos.uc.model.UcUser;
import cj.netos.uc.service.IUcUserService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "/register")
public class UserRegister implements IUserRegisterPort {
    @CjServiceRef(refByName = "ucplugin.ucUserService")
    IUcUserService ucUserService;

    @Override
    public UcUser registerByPassword(String tenant, String accountName, String password) throws CircuitException {
        return ucUserService.registerByPassword(tenant, accountName, password);
    }

    @Override
    public UcUser registerByIphone(String tenant, String phone, String password) throws CircuitException {
        return ucUserService.registerByIphone(tenant, phone, password);
    }

    @Override
    public UcUser registerByEmail(String tenant, String email, String password) throws CircuitException {
        return ucUserService.registerByEmail(tenant, email, password);
    }
}
