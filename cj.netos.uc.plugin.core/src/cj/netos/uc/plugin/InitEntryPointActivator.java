package cj.netos.uc.plugin;

import cj.netos.uc.service.IDBInit;
import cj.studio.ecm.EcmException;
import cj.studio.ecm.IEntryPointActivator;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.context.IElement;
import cj.studio.ecm.net.CircuitException;

public class InitEntryPointActivator implements IEntryPointActivator {

    @Override
    public void activate(IServiceSite site, IElement args) {
        IDBInit init = (IDBInit) site.getService("dbInit");
        try {
            init.init(site,args);
        } catch (CircuitException e) {
            throw new EcmException(e);
        }
    }

    @Override
    public void inactivate(IServiceSite site) {

    }
}
