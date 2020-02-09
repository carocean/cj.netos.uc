package cj.netos.uc.service;

public interface IPhoneVerifycodeService {
    String get(String person);
    void set(String person,String verifycode);
}
