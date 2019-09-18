package cj.netos.uc.port;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "修改密码")
public interface IPasswordPort extends IOpenportService {
    @CjOpenport(usage = "修改密码")
    void updatePassword(@CjOpenportParameter(usage = "租户标识", name = "tenantid") String tenantid, @CjOpenportParameter(usage = "账户名", name = "accountName") String accountName, @CjOpenportParameter(usage = "旧密码", name = "oldpwd") String oldpwd, @CjOpenportParameter(usage = "新密码", name = "newpwd") String newpwd) throws CircuitException;
}
