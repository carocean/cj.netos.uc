package cj.netos.uc.plugin.dao;

import cj.netos.uc.domain.UcUserSegment;
import cj.netos.uc.domain.UcUserSegmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserSegmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    long countByExample(UcUserSegmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int deleteByExample(UcUserSegmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int deleteByPrimaryKey(String segmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int insert(UcUserSegment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int insertSelective(UcUserSegment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    List<UcUserSegment> selectByExample(UcUserSegmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    UcUserSegment selectByPrimaryKey(String segmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int updateByExampleSelective(@Param("record") UcUserSegment record, @Param("example") UcUserSegmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int updateByExample(@Param("record") UcUserSegment record, @Param("example") UcUserSegmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int updateByPrimaryKeySelective(UcUserSegment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uc_user_seg
     *
     * @mbg.generated Mon Sep 16 16:08:22 PHT 2019
     */
    int updateByPrimaryKey(UcUserSegment record);
}