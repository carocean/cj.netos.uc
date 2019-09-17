package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.TenantRole;
import cj.netos.uc.domain.TenantRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenantRoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	long countByExample(TenantRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int deleteByExample(TenantRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int deleteByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int insert(TenantRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int insertSelective(TenantRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	List<TenantRole> selectByExample(TenantRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	TenantRole selectByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int updateByExampleSelective(@Param("record") TenantRole record, @Param("example") TenantRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int updateByExample(@Param("record") TenantRole record, @Param("example") TenantRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int updateByPrimaryKeySelective(TenantRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Tue Sep 17 12:57:10 PHT 2019
	 */
	int updateByPrimaryKey(TenantRole record);
}