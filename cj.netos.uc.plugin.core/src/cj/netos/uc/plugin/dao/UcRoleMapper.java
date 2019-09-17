package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcRoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	long countByExample(UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int deleteByExample(UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int deleteByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int insert(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int insertSelective(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	List<UcRole> selectByExample(UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	UcRole selectByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByExampleSelective(@Param("record") UcRole record, @Param("example") UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByExample(@Param("record") UcRole record, @Param("example") UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByPrimaryKeySelective(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByPrimaryKey(UcRole record);
}