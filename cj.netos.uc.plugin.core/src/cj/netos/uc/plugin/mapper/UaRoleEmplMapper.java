package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UaRoleEmpl;
import cj.netos.uc.model.UaRoleEmplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UaRoleEmplMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UaRoleEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UaRoleEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("emplId") String emplId, @Param("roleId") String roleId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UaRoleEmpl record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UaRoleEmpl record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UaRoleEmpl> selectByExample(UaRoleEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UaRoleEmpl record, @Param("example") UaRoleEmplExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UaRoleEmpl record, @Param("example") UaRoleEmplExample example);
}