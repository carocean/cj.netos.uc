package cj.netos.uc.service;

public interface ITenantTokenService {
	String genToken(String tenant,String user,long ttlMillis);
}
