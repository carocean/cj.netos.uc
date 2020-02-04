package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcDept;
import cj.netos.uc.model.UcDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcDeptMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcDeptExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcDeptExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String deptId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcDept record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcDept record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcDept> selectByExample(UcDeptExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcDept selectByPrimaryKey(String deptId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcDept record, @Param("example") UcDeptExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcDept record, @Param("example") UcDeptExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcDept record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcDept record);

    List<UcDept> pageChildren(@Param(value = "parentDeptid") String parentDeptid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<UcDept> pageDeptOfCompany(@Param(value = "companyid") String companyid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);
}