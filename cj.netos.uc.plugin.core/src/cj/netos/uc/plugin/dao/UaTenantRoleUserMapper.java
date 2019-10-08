package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UaTenantRoleUserExample;
import cj.netos.uc.domain.UaTenantRoleUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UaTenantRoleUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	long countByExample(UaTenantRoleUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	int deleteByExample(UaTenantRoleUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	int deleteByPrimaryKey(UaTenantRoleUserKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	int insert(UaTenantRoleUserKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	int insertSelective(UaTenantRoleUserKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	List<UaTenantRoleUserKey> selectByExample(UaTenantRoleUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	int updateByExampleSelective(@Param("record") UaTenantRoleUserKey record,
			@Param("example") UaTenantRoleUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_tenant_role_user
	 * @mbg.generated  Tue Oct 08 11:15:14 CST 2019
	 */
	int updateByExample(@Param("record") UaTenantRoleUserKey record, @Param("example") UaTenantRoleUserExample example);
}