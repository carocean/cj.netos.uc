package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UcRole;
import cj.netos.uc.domain.UcRoleExample;
import java.util.List;

import cj.netos.uc.domain.UcUser;
import org.apache.ibatis.annotations.Param;

public interface UcRoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	long countByExample(UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int deleteByExample(UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int deleteByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int insert(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int insertSelective(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	List<UcRole> selectByExample(UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	UcRole selectByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int updateByExampleSelective(@Param("record") UcRole record, @Param("example") UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int updateByExample(@Param("record") UcRole record, @Param("example") UcRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int updateByPrimaryKeySelective(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_role
	 * @mbg.generated  Fri Sep 27 14:13:15 PHT 2019
	 */
	int updateByPrimaryKey(UcRole record);

	List<UcRole> pageRole(@Param(value = "currPage") int currPage, @Param(value = "pageSize")int pageSize);

	List<UcUser> pageUserInRole( @Param(value = "roleid") String roleid, @Param(value = "currPage") int currPage, @Param(value = "pageSize")int pageSize);
	List<UcRole> pageRoleOfUser(@Param(value = "uid")String uid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);
}