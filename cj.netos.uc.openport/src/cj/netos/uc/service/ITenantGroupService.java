package cj.netos.uc.service;

import java.util.List;

import cj.netos.uc.bo.Account;
import cj.netos.uc.bo.TenantGroup;

public interface ITenantGroupService {

	void addGroup(TenantGroup group);

	TenantGroup getGroup(String tenantCode, String groupCode);

	void removeGroup(String tenantCode, String groupCode);

	List<TenantGroup> pageGroup(String tenantCode, int currPage, int pageSize);

	List<Account> getAccountsOnGroup(String tenantCode, String groupCode);

	List<Account> pageAccountsOnGroup(String tenantCode, String groupCode, int currPage, int pageSize);

	void addAccountOnGroup(String tenantCode, String accountCode, String groupCode);

	void removeAccountOnGroup(String tenantCode, String accountCode, String groupCode);

	void emptyAccountsOnGroup(String tenantCode, String groupCode);

}
