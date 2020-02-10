package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.DomainValue;
import cj.netos.uc.model.DomainValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomainValueMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DomainValueExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DomainValueExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("fieldId") String fieldId, @Param("uid") String uid);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(DomainValue record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(DomainValue record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DomainValue> selectByExample(DomainValueExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    DomainValue selectByPrimaryKey(@Param("fieldId") String fieldId, @Param("uid") String uid);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") DomainValue record, @Param("example") DomainValueExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") DomainValue record, @Param("example") DomainValueExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(DomainValue record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(DomainValue record);

    void updateDomainValue(String userId, String fieldId, String content);

    void emptyDomainValue(String userId, String fieldId);

}