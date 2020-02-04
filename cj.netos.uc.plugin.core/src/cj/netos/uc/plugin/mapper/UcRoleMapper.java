package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.UcRole;
import cj.netos.uc.model.UcRoleExample;
import cj.netos.uc.model.UcUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UcRoleMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UcRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UcRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UcRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UcRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UcRole> selectByExample(UcRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UcRole selectByPrimaryKey(String roleId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") UcRole record, @Param("example") UcRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") UcRole record, @Param("example") UcRoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UcRole record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UcRole record);

    List<UcRole> pageRole(@Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<UcUser> pageUserInRole(@Param(value = "roleid") String roleid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    List<UcRole> pageRoleOfUser(@Param(value = "uid") String uid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);
}