package cj.netos.uc.port;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "用户中心属性，仅供系统管理员使用")
public interface IUcPropertiesPorts {
    @CjOpenport(usage = "获取属性")
    String get(ISecuritySession securitySession,@CjOpenportParameter(usage = "key",name = "key") String key) throws CircuitException;

    @CjOpenport(usage = "设置属性")
    void set(ISecuritySession securitySession,@CjOpenportParameter(usage = "key",name = "key") String key,
             @CjOpenportParameter(usage = "value",name = "value") String value) throws CircuitException;

    @CjOpenport(usage = "获取属性键")
    List<String> keys(ISecuritySession securitySession) throws CircuitException;
}
