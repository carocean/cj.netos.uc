package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcCompany;
import cj.netos.uc.model.UcCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcCompanyMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcCompanyExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcCompanyExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String companyId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcCompany record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcCompany record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcCompany> selectByExample(UcCompanyExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcCompany selectByPrimaryKey(String companyId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcCompany record, @Param("example") UcCompanyExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcCompany record, @Param("example") UcCompanyExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcCompany record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcCompany record);

    List<UcCompany> pageCompany(@Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<UcCompany> pageChildren(@Param(value = "pid") String pid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    void emptyChildren(@Param(value = "pid") String pid);
}