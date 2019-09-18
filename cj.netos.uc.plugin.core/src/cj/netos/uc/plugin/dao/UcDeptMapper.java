package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UcDept;
import cj.netos.uc.domain.UcDeptExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UcDeptMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    long countByExample(UcDeptExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int deleteByExample(UcDeptExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int deleteByPrimaryKey(String deptId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int insert(UcDept record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int insertSelective(UcDept record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    List<UcDept> selectByExample(UcDeptExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    UcDept selectByPrimaryKey(String deptId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int updateByExampleSelective(@Param("record") UcDept record, @Param("example") UcDeptExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int updateByExample(@Param("record") UcDept record, @Param("example") UcDeptExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int updateByPrimaryKeySelective(UcDept record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table uc_dept
     *
     * @mbg.generated Wed Sep 18 02:11:41 CST 2019
     */
    int updateByPrimaryKey(UcDept record);

    List<UcDept> pageChildren(@Param(value = "parentDeptid") String parentDeptid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<UcDept> pageDeptOfCompany(@Param(value = "companyid") String companyid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

}