package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.TenantRole;
import cj.netos.uc.model.TenantRoleExample;

import java.util.List;

import cj.netos.uc.model.UcUser;
import org.apache.ibatis.annotations.Param;

public interface TenantRoleMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(TenantRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(TenantRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("tenantId") String tenantId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(TenantRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(TenantRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<TenantRole> selectByExample(TenantRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    TenantRole selectByPrimaryKey(@Param("roleId") String roleId, @Param("tenantId") String tenantId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") TenantRole record, @Param("example") TenantRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") TenantRole record, @Param("example") TenantRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(TenantRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(TenantRole record);

    List<TenantRole> pageRole(@Param(value = "tenantid") String tenantid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<UcUser> pageUserInRole(@Param(value = "roleid") String roleid, @Param(value = "tenantid") String tenantid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<TenantRole> pageRoleOfUser(@Param(value = "uid") String uid, @Param(value = "tenantid") String tenantid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

}