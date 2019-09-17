package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UcCompany;
import cj.netos.uc.domain.UcCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcCompanyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	long countByExample(UcCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int deleteByExample(UcCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int deleteByPrimaryKey(String companyId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int insert(UcCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int insertSelective(UcCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	List<UcCompany> selectByExample(UcCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	UcCompany selectByPrimaryKey(String companyId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByExampleSelective(@Param("record") UcCompany record, @Param("example") UcCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByExample(@Param("record") UcCompany record, @Param("example") UcCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByPrimaryKeySelective(UcCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table uc_company
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	int updateByPrimaryKey(UcCompany record);
}