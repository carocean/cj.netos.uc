package cj.netos.uc.service;

import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.context.IElement;
import cj.studio.ecm.net.CircuitException;

public interface IDBInit {
    void init(IServiceSite site, IElement args) throws CircuitException;
}
