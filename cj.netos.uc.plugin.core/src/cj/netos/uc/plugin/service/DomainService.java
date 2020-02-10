package cj.netos.uc.plugin.service;

import cj.netos.uc.model.*;
import cj.netos.uc.plugin.mapper.DomainFieldMapper;
import cj.netos.uc.plugin.mapper.DomainGroupMapper;
import cj.netos.uc.plugin.mapper.DomainValueMapper;
import cj.netos.uc.service.IDomainService;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "domainService")
public class DomainService implements IDomainService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.DomainGroupMapper")
    DomainGroupMapper domainGroupMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.DomainFieldMapper")
    DomainFieldMapper domainFieldMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.DomainValueMapper")
    DomainValueMapper domainValueMapper;

    @CjTransaction
    @Override
    public void addDomainGroup(String groupId, String groupName) {
        DomainGroup group = new DomainGroup();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        domainGroupMapper.insertSelective(group);
    }

    @CjTransaction
    @Override
    public void removeDomainGroup(String groupId) {
        domainGroupMapper.deleteByPrimaryKey(groupId);
    }

    @CjTransaction
    @Override
    public List<DomainGroup> listAllDomainGroup() {
        DomainGroupExample example = new DomainGroupExample();
        return domainGroupMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void addDomainField(String fieldCode, String groupId, String fieldName, String fieldDesc) {
        DomainField field = new DomainField();
        field.setFieldDesc(fieldDesc);
        field.setFieldId(String.format("%s.%s", fieldCode, groupId));
        field.setGroupId(groupId);
        field.setFieldName(fieldName);
        this.domainFieldMapper.insertSelective(field);
    }

    @CjTransaction
    @Override
    public void removeDomainField(String fieldId) {
        this.domainFieldMapper.deleteByPrimaryKey(fieldId);
    }

    @CjTransaction
    @Override
    public List<DomainField> listDomainField(String groupId) {
        DomainFieldExample example = new DomainFieldExample();
        example.createCriteria().andGroupIdEqualTo(groupId);
        return domainFieldMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void emptyDomainField(String groupId) {
        DomainFieldExample example = new DomainFieldExample();
        example.createCriteria().andGroupIdEqualTo(groupId);
        domainFieldMapper.deleteByExample(example);
    }

    @CjTransaction
    @Override
    public void setDomainValue(String userId, String groupId, String fieldId, String content) {
        DomainValue value = getDomainValue(userId, fieldId);
        if (value != null) {
            value.setContent(content);
            domainValueMapper.updateDomainValue(userId, fieldId, content);
            return;
        }
        value = new DomainValue();
        value.setContent(content);
        value.setFieldId(fieldId);
        value.setGroupId(groupId);
        value.setUid(userId);
        domainValueMapper.insertSelective(value);
    }

    @CjTransaction
    @Override
    public DomainValue getDomainValue(String userId, String fieldId) {
        return domainValueMapper.selectByPrimaryKey(fieldId, userId);
    }

    @CjTransaction
    @Override
    public void emptyDomainValue(String userId, String fieldId) {
        domainValueMapper.emptyDomainValue(userId, fieldId);
    }

    @CjTransaction
    @Override
    public List<DomainValue> listDomainValueOfGroup(String userId, String groupId) {
        DomainValueExample example = new DomainValueExample();
        example.createCriteria().andUidEqualTo(userId).andGroupIdEqualTo(groupId);
        return domainValueMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<DomainValue> listAllDomainValue(String userId) {
        DomainValueExample example = new DomainValueExample();
        example.createCriteria().andUidEqualTo(userId);
        return domainValueMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public DomainGroup getDomainGroup(String groupId) {
        return domainGroupMapper.selectByPrimaryKey(groupId);
    }

    @CjTransaction
    @Override
    public DomainField getDomainField(String fieldId) {
        return domainFieldMapper.selectByPrimaryKey(fieldId);
    }
}
