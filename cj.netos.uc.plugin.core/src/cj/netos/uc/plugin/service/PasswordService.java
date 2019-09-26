package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.AppAccount;
import cj.netos.uc.service.IAppAccountService;
import cj.netos.uc.service.IPasswordService;
import cj.netos.uc.util.Encript;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "passwordService")
public class PasswordService implements IPasswordService {
    @CjServiceRef
    IAppAccountService appAccountService;
    @Override
    public void updatePassword(String tenantid, String accountName, String oldpwd, String newpwd) throws CircuitException {
        AppAccount account=appAccountService.getAccountByName(tenantid,accountName);
        if(account==null){
            throw new CircuitException("404","用户不存在:"+accountName);
        }
        if(!account.getAccountPwd().equals(Encript.md5(oldpwd))){
            throw new CircuitException("404",String.format("用户:%s 原密码不正确.",account));
        }
        newpwd= Encript.md5(newpwd);
        appAccountService.updatePwd(account.getAccountId(),newpwd);
    }
}
