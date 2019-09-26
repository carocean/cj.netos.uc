package cj.netos.uc.port;

import cj.netos.uc.domain.AppAccount;
import cj.netos.uc.domain.UcUser;
import cj.netos.uc.service.IAppAccountService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

@CjService(name = "/app/account")
public class AppAccountPorts implements IAppAccountPort {
    @CjServiceRef(refByName = "ucplugin.appAccountService")
    IAppAccountService appAccountService;

    @Override
    public String addAccount(AppAccount account) throws CircuitException {
        return appAccountService.addAccount(account);
    }

    @Override
    public void addByIphone(String uid, String appid, String phone, String password) throws CircuitException {
        appAccountService.addByIphone(uid, appid, phone, password);
    }

    @Override
    public void addByEmail(String uid, String appid, String email, String password) throws CircuitException {
        appAccountService.addByEmail(uid, appid, email, password);
    }

    @Override
    public UcUser getUser(String appid, String accountName) throws CircuitException {
        return appAccountService.getUser(appid, accountName);
    }

    @Override
    public void removeAccount(String accountid) throws CircuitException {
        appAccountService.removeAccount(accountid);
    }

    @Override
    public List<AppAccount> pageAccount(String appid, int currPage, int pageSize) throws CircuitException {
        return appAccountService.pageAccount(appid, currPage, pageSize);
    }

    @Override
    public List<AppAccount> listAccount(String uid) throws CircuitException {
        return appAccountService.listAccount(uid);
    }

    @Override
    public AppAccount getAccount(String accountid) throws CircuitException {
        return appAccountService.getAccount(accountid);
    }

    @Override
    public void setAccountEnable(String accountid,boolean enable) throws CircuitException {
        appAccountService.setAccountEnable(accountid,enable);
    }
}
