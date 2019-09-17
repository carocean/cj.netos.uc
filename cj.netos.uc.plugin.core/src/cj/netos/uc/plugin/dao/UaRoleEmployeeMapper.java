package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UaRoleEmployeeExample;
import cj.netos.uc.domain.UaRoleEmployeeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UaRoleEmployeeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	long countByExample(UaRoleEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int deleteByExample(UaRoleEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int deleteByPrimaryKey(UaRoleEmployeeKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int insert(UaRoleEmployeeKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int insertSelective(UaRoleEmployeeKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	List<UaRoleEmployeeKey> selectByExample(UaRoleEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByExampleSelective(@Param("record") UaRoleEmployeeKey record,
			@Param("example") UaRoleEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ua_role_empl
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByExample(@Param("record") UaRoleEmployeeKey record, @Param("example") UaRoleEmployeeExample example);
}