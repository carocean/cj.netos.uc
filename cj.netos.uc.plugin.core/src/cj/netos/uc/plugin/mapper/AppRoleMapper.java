package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.AppRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
    int insert(AppRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AppRole record);

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
    int updateByExampleSelective(@Param("record") AppRole record, @Param("example") AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AppRole record, @Param("example") AppRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AppRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AppRole record);

    List<AppRole> pageRole(@Param(value = "appid") String appid, @Param(value = "offset") long office, @Param(value = "limit") long limit);
}