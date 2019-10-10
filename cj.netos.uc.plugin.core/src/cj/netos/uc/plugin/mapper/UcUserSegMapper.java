package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcUserSeg;
import cj.netos.uc.model.UcUserSegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserSegMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcUserSegExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcUserSegExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String segmentId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcUserSeg record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcUserSeg record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcUserSeg> selectByExample(UcUserSegExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcUserSeg selectByPrimaryKey(String segmentId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcUserSeg record, @Param("example") UcUserSegExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcUserSeg record, @Param("example") UcUserSegExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcUserSeg record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcUserSeg record);
}