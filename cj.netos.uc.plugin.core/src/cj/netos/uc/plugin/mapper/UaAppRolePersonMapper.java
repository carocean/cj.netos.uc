package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.AppRole;
import cj.netos.uc.model.UaAppRolePerson;
import cj.netos.uc.model.UaAppRolePersonExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UaAppRolePersonMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UaAppRolePersonExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UaAppRolePersonExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("accountId") String accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UaAppRolePerson record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UaAppRolePerson record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UaAppRolePerson> selectByExample(UaAppRolePersonExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UaAppRolePerson selectByPrimaryKey(@Param("roleId") String roleId, @Param("accountId") String accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UaAppRolePerson record, @Param("example") UaAppRolePersonExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UaAppRolePerson record, @Param("example") UaAppRolePersonExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UaAppRolePerson record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UaAppRolePerson record);

    List<AppAccount> pageAccountInRole(@Param(value = "appId") String appId, @Param(value = "roleid") String roleid, @Param(value = "offset") long offset, @Param(value = "limit") long limit);

    List<AppRole> pageRoleOfAccount(@Param(value = "accountid") String accountid, @Param(value = "appId") String appId, @Param(value = "offset") long offset, @Param(value = "limit") long limit);
}