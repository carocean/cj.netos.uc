package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppAccountSource;
import cj.netos.uc.model.AppAccountSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppAccountSourceMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AppAccountSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AppAccountSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("accountId") String accountId, @Param("subSystem") String subSystem, @Param("subSysOpenid") String subSysOpenid);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AppAccountSource record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AppAccountSource record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AppAccountSource> selectByExample(AppAccountSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") AppAccountSource record, @Param("example") AppAccountSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AppAccountSource record, @Param("example") AppAccountSourceExample example);
}