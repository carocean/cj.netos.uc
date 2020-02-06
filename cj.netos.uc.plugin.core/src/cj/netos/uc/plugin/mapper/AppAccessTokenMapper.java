package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppAccessToken;
import cj.netos.uc.model.AppAccessTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppAccessTokenMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AppAccessTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AppAccessTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("person") String person, @Param("device") String device);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AppAccessToken record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AppAccessToken record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AppAccessToken> selectByExample(AppAccessTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    AppAccessToken selectByPrimaryKey(@Param("person") String person, @Param("device") String device);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") AppAccessToken record, @Param("example") AppAccessTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AppAccessToken record, @Param("example") AppAccessTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AppAccessToken record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AppAccessToken record);
}