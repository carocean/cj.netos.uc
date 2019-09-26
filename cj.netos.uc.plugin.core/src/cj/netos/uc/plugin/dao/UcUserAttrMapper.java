package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UcUserAttr;
import cj.netos.uc.domain.UcUserAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserAttrMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	long countByExample(UcUserAttrExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int deleteByExample(UcUserAttrExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int deleteByPrimaryKey(String attributeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int insert(UcUserAttr record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int insertSelective(UcUserAttr record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	List<UcUserAttr> selectByExample(UcUserAttrExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	UcUserAttr selectByPrimaryKey(String attributeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int updateByExampleSelective(@Param("record") UcUserAttr record, @Param("example") UcUserAttrExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int updateByExample(@Param("record") UcUserAttr record, @Param("example") UcUserAttrExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int updateByPrimaryKeySelective(UcUserAttr record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_user_attr
	 * @mbg.generated  Thu Sep 26 21:07:00 PHT 2019
	 */
	int updateByPrimaryKey(UcUserAttr record);
}