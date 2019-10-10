package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcUser;
import cj.netos.uc.model.UcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcUser> selectByExample(UcUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcUser selectByPrimaryKey(String userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcUser record, @Param("example") UcUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcUser record, @Param("example") UcUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcUser record);

    List<UcUser> pageUser(@Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

}