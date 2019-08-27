package cj.netos.uc.service;

import java.util.List;

import cj.netos.uc.bo.Account;
import cj.netos.uc.bo.AccountAttribute;
import cj.netos.uc.bo.AccountSegment;
import cj.netos.uc.bo.GlobalRole;
import cj.netos.uc.bo.Organization;
import cj.netos.uc.bo.Segment;
import cj.netos.uc.bo.TenantGroup;
import cj.netos.uc.bo.TenantPost;
import cj.netos.uc.bo.TenantRole;

public interface IAccountService {
	void addAccount(Account account);

	void removeAccount(String tenantCode,String accountCode);

	Account getAccount(String tenantCode,String accountCode);

	long getAccountCount(String tenantCode);

	List<Account> getPage(String tenantCode,int currPage, int pageSize);

	List<Segment> getSegmentsOfAccount(String tenantCode,String accountCode);

	void addSegmentOfAccount(AccountSegment seg);

	void removeSegmentOfAccount(String tenantCode, String segCode);

	void emptySegmentsOfAccount(String tenantCode);

	void addAccountAttribute(AccountAttribute attr);

	void removeAccountAttribute(String tenantCode,String accountCode, String segCode, String attrCode);

	void emptyAccountAttributes(String tenantCode,String accountCode, String segCode);

	List<AccountAttribute> getAccountAttributes(String tenantCode,String accountCode, String segCode);

	Account getAccountByAttrValue(String tenantCode,String segCode, String attrCode, String value);

	List<Account> findAccountsWhereCodeList(List<String> where);

	List<GlobalRole> listGlobalRoleOfAccount(String accountCode, String tenantCode);

	List<TenantRole> listTenantRoleOfAccount(String accountCode, String tenantCode);

	List<TenantPost> listTenantPostOfAccount(String accountCode, String tenantCode);

	List<TenantGroup> listTenantGroupOfAccount(String accountCode, String tenantCode);

	List<Organization> listTenantOrganizationOfAccount(String accountCode, String tenantCode);

	List<Account> getAccountByAttrValueOnSegment(String tenantCode, String segCode, String value);

}
