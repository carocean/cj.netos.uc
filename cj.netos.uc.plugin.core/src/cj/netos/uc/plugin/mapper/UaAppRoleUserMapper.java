package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.UaAppRoleUser;
import cj.netos.uc.model.UaAppRoleUserExample;
import java.util.List;

import cj.netos.uc.model.UcUser;
import org.apache.ibatis.annotations.Param;

public interface UaAppRoleUserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UaAppRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UaAppRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("userId") String userId, @Param("appId") String appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UaAppRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UaAppRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UaAppRoleUser> selectByExample(UaAppRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UaAppRoleUser record, @Param("example") UaAppRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UaAppRoleUser record, @Param("example") UaAppRoleUserExample example);


    List<UcUser> pageUserInRole(@Param(value = "appid") String appid,@Param(value = "roleid") String roleid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<AppRole> pageRoleInUser(@Param(value = "uid")String uid,@Param(value = "appid") String appid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);
}