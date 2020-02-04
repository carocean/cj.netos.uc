package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppRefreshToken;
import cj.netos.uc.model.AppRefreshTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppRefreshTokenMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AppRefreshTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AppRefreshTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AppRefreshToken record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AppRefreshToken record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AppRefreshToken> selectByExample(AppRefreshTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    AppRefreshToken selectByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") AppRefreshToken record, @Param("example") AppRefreshTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AppRefreshToken record, @Param("example") AppRefreshTokenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AppRefreshToken record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AppRefreshToken record);
}