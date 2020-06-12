package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.DomainGroup;
import cj.netos.uc.model.DomainGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomainGroupMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DomainGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DomainGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String groupId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(DomainGroup record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(DomainGroup record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DomainGroup> selectByExample(DomainGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    DomainGroup selectByPrimaryKey(String groupId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") DomainGroup record, @Param("example") DomainGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") DomainGroup record, @Param("example") DomainGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(DomainGroup record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(DomainGroup record);
}