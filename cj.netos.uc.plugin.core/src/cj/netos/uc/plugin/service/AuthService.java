package cj.netos.uc.plugin.service;

import cj.netos.uc.domain.IdentityInfo;
import cj.netos.uc.domain.TenantAccount;
import cj.netos.uc.plugin.util.Encript;
import cj.netos.uc.service.IAuthService;
import cj.netos.uc.service.ITenantAccountService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "authService")
public class AuthService implements IAuthService {
    @CjServiceRef
    ITenantAccountService tenantAccountService;

    @Override
    public IdentityInfo auth( String tenantid, String accountName, String password) throws CircuitException {
        TenantAccount account = tenantAccountService.getAccountByName(tenantid, accountName);
        if (account == null) {
            throw new CircuitException("404", "用户不存在:" + accountName);
        }
        if (!account.getAccountPwd().equals(Encript.md5(password))) {
            throw new CircuitException("404", String.format("用户:%s 密码不正确.", account));
        }
        IdentityInfo identityInfo = new IdentityInfo();
        identityInfo.setAccountid(account.getAccountId());
        identityInfo.setAccountName(account.getAccountName());
        identityInfo.setTenantid(account.getTenantId());
        identityInfo.setUid(account.getUserId());
        return identityInfo;
    }
}
