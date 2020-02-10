package cj.netos.uc.service;

import cj.netos.uc.model.DomainField;
import cj.netos.uc.model.DomainGroup;
import cj.netos.uc.model.DomainValue;

import java.util.List;

public interface IDomainService {
    void addDomainGroup(String groupId, String groupName);

    void removeDomainGroup(String groupId);

    List<DomainGroup> listAllDomainGroup();

    void addDomainField(String fieldCode,String groupId, String fieldName, String fieldDesc);

    void removeDomainField(String fieldId);

    List<DomainField> listDomainField(String groupId);

    void emptyDomainField(String groupId);

    void setDomainValue(String userId, String groupId, String fieldId, String content);

    void emptyDomainValue(String userId, String fieldId);

    List<DomainValue> listDomainValueOfGroup(String userId, String groupId);

    List<DomainValue> listAllDomainValue(String userId);

    DomainGroup getDomainGroup(String groupId);

    DomainField getDomainField(String fieldId);

    DomainValue getDomainValue(String userId, String fieldId);

}
