package cj.netos.uc.service;

import java.util.List;

public interface IUcProperties {
    String get(String key);
    void set(String key,String value);
    List<String> keys();
}
