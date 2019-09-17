package cj.netos.uc.port;

import cj.netos.uc.domain.UcEmployee;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.InRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "员工")
public interface IUcEmployeePort extends IOpenportService {
    @CjOpenport(command = "post", usage = "添加员工")
    String addEmployee(@CjOpenportParameter(usage = "员工", name = "employee", in = InRequest.content) UcEmployee employee) throws CircuitException;

    @CjOpenport(usage = "移除员工")
    void removeEmployee(@CjOpenportParameter(name = "emplid", usage = "员工标识") String emplid) throws CircuitException;

    @CjOpenport(usage = "获取员工")
    UcEmployee getEmployee(@CjOpenportParameter(name = "emplid", usage = "员工标识") String emplid) throws CircuitException;
}
