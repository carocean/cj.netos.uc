package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UaTenantRoleUser;
import cj.netos.uc.model.UaTenantRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UaTenantRoleUserMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UaTenantRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UaTenantRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("userId") String userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UaTenantRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UaTenantRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UaTenantRoleUser> selectByExample(UaTenantRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UaTenantRoleUser selectByPrimaryKey(@Param("roleId") String roleId, @Param("userId") String userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UaTenantRoleUser record, @Param("example") UaTenantRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UaTenantRoleUser record, @Param("example") UaTenantRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UaTenantRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UaTenantRoleUser record);
}