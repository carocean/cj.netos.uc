package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UaRoleUser;
import cj.netos.uc.model.UaRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UaRoleUserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UaRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UaRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("userId") String userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UaRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UaRoleUser record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UaRoleUser> selectByExample(UaRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UaRoleUser record, @Param("example") UaRoleUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UaRoleUser record, @Param("example") UaRoleUserExample example);
}