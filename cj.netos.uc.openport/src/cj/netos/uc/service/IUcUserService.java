package cj.netos.uc.service;

import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcUserService {
    String addUser(String uid,String userName, String sex, String email, String mobile, String idcard) throws CircuitException;

    List<UcUser> pageUser(int currPage, int pageSize) throws CircuitException;

    long getUserCount() throws CircuitException;


    UcUser registerByPassword(String appid, String accountCode, String password, String nickName, String avatar, String signature)throws CircuitException;

    UcUser registerByIphone(String appid, String phone, String password, String nickName, String avatar, String signature) throws CircuitException;

    UcUser registerByEmail(String appid, String email, String password, String nickName, String avatar, String signature) throws CircuitException;


    UcUser getUserById(String uid);


    void updateProfile(String uid, UcUser user) throws CircuitException;

    boolean isEmployee(String uid) throws CircuitException;


    void updateRealName(String userId, String realName)throws CircuitException;

    void updateSex(String userId, String sex);

}
