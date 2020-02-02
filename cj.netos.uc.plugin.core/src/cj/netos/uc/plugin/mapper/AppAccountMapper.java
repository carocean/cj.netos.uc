package cj.netos.uc.plugin.mapper;

import cj.netos.uc.model.AppAccount;
import cj.netos.uc.model.AppAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppAccountMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AppAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AppAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AppAccount record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AppAccount record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AppAccount> selectByExample(AppAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    AppAccount selectByPrimaryKey(String accountId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") AppAccount record, @Param("example") AppAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AppAccount record, @Param("example") AppAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AppAccount record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AppAccount record);

    void updateAccountEnable(@Param(value = "accountid") String accountid, @Param(value = "enable") boolean enable);

    List<AppAccount> pageAccount(@Param(value = "appid") String tenantid, @Param(value = "currPage") int currPage, @Param(value = "pageSize") int pageSize);

    void updatePwd(@Param(value = "accountid") String accountid, @Param(value = "newpwd") String newpwd);
}