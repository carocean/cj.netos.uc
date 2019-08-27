package cj.netos.uc.service;

public interface ITokenService {
	boolean verify(String token);
	String parseToken(String token);
}
