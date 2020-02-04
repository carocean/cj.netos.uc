package cj.netos.uc.port;

import cj.netos.uc.model.PersonInfo;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

@CjService(name = "/person/self.service")
public class PersonSelfServicePorts implements IPersonSelfServicePorts {
    @Override
    public void updatePassword(ISecuritySession securitySession, String oldpwd, String newpwd) throws CircuitException {

    }

    @Override
    public void updatePersonAvatar(ISecuritySession securitySession, String avatar) throws CircuitException {

    }

    @Override
    public void updatePersonSignature(ISecuritySession securitySession, String signature) throws CircuitException {

    }

    @Override
    public void updatePersonNickName(ISecuritySession securitySession, String nickName) throws CircuitException {

    }

    @Override
    public PersonInfo getPersonInfo(ISecuritySession securitySession) throws CircuitException {
        return null;
    }

    @Override
    public void addByPassword(ISecuritySession securitySession, String accountName, String password, String nickName, String avatar, String signature) throws CircuitException {

    }

    @Override
    public void addByIphone(ISecuritySession securitySession, String phone, String password, String nickName, String avatar, String signature) throws CircuitException {

    }

    @Override
    public void addByEmail(ISecuritySession securitySession, String email, String password, String nickName, String avatar, String signature) throws CircuitException {

    }
}
