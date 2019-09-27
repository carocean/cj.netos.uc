package cj.netos.uc.service;

import cj.studio.ecm.net.CircuitException;

public interface IKeyStore {
    String getKey() throws CircuitException;
}
