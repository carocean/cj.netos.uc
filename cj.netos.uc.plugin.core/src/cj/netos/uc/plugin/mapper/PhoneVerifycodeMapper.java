package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.PhoneVerifycode;
import cj.netos.uc.model.PhoneVerifycodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneVerifycodeMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(PhoneVerifycodeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(PhoneVerifycodeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(PhoneVerifycode record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(PhoneVerifycode record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<PhoneVerifycode> selectByExample(PhoneVerifycodeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    PhoneVerifycode selectByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") PhoneVerifycode record, @Param("example") PhoneVerifycodeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") PhoneVerifycode record, @Param("example") PhoneVerifycodeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(PhoneVerifycode record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(PhoneVerifycode record);
}