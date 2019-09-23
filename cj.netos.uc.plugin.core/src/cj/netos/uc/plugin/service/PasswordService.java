package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.util.Encript;
import cj.netos.uc.service.IPasswordService;
import cj.netos.uc.service.ITenantAccountService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "passwordService")
public class PasswordService implements IPasswordService {
    @CjServiceRef
    ITenantAccountService tenantAccountService;
    @Override
    public void updatePassword(String tenantid, String accountName, String oldpwd, String newpwd) throws CircuitException {
        TenantAccount account=tenantAccountService.getAccountByName(tenantid,accountName);
        if(account==null){
            throw new CircuitException("404","用户不存在:"+accountName);
        }
        if(!account.getAccountPwd().equals(Encript.md5(oldpwd))){
            throw new CircuitException("404",String.format("用户:%s 原密码不正确.",account));
        }
        newpwd= Encript.md5(newpwd);
        tenantAccountService.updatePwd(account.getAccountId(),newpwd);
    }
}
