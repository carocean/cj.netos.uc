package cj.netos.uc.service;

import cj.netos.uc.model.UcRole;
import cj.netos.uc.model.UcUser;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IUcRoleService {
    String addRole(String roleid,String name, boolean isInheritable) throws CircuitException;

    void removeRole(String roleid) throws CircuitException;

    UcRole getRole(String roleid) throws CircuitException;

    List<UcRole> pageRole(int currPage, int pageSize) throws CircuitException;

    List<UcUser> pageUserInRole(String roleid, int currPage, int pageSize) throws CircuitException;

    List<UcRole> pageRoleOfUser(String uid, int currPage, int pageSize) throws CircuitException;


    void addRoleToUser(String roleid, String uid) throws CircuitException;

    void removeRoleFromUser(String roleid, String uid) throws CircuitException;

    boolean hasRoleOfUser(String roleid, String uid);

}
