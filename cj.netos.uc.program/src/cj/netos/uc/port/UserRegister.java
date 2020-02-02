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
    public UcUser registerByPassword(String appid, String accountName, String password, String nickName, String avatar, String signature) throws CircuitException {
        return ucUserService.registerByPassword(appid, accountName, password,nickName,avatar,signature);
    }

    @Override
    public UcUser registerByIphone(String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {
        return ucUserService.registerByIphone(appid,phone,password,nickName,avatar,signature);
    }

    @Override
    public UcUser registerByEmail(String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException {
        return ucUserService.registerByEmail(appid,email,password,nickName,avatar,signature);
    }

}
