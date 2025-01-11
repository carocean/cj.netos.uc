package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.AppRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppRoleMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AppRole row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AppRole row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AppRole> selectByExample(AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    AppRole selectByPrimaryKey(String roleId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") AppRole row, @Param("example") AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") AppRole row, @Param("example") AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AppRole row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AppRole row);



    List<AppRole> pageRole(@Param(value = "appid") String appid, @Param(value = "offset") long office, @Param(value = "limit") long limit);
}