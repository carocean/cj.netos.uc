package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.DomainField;
import cj.netos.uc.model.DomainFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomainFieldMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DomainFieldExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DomainFieldExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String fieldId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(DomainField record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(DomainField record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DomainField> selectByExample(DomainFieldExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    DomainField selectByPrimaryKey(String fieldId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") DomainField record, @Param("example") DomainFieldExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") DomainField record, @Param("example") DomainFieldExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(DomainField record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(DomainField record);
}