package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcEmpl;
import cj.netos.uc.model.UcEmplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcEmplMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String emplId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcEmpl record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcEmpl record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcEmpl> selectByExample(UcEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcEmpl selectByPrimaryKey(String emplId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcEmpl record, @Param("example") UcEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcEmpl record, @Param("example") UcEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcEmpl record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcEmpl record);
}