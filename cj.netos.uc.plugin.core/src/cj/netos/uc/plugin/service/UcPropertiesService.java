package cj.netos.uc.plugin.service;

import cj.netos.uc.model.UcProperties;
import cj.netos.uc.model.UcPropertiesExample;
import cj.netos.uc.plugin.mapper.UcPropertiesMapper;
import cj.netos.uc.plugin.mapper.UcRoleMapper;
import cj.netos.uc.service.IUcProperties;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CjService(name = "ucProperties")
public class UcPropertiesService implements IUcProperties {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.UcPropertiesMapper")
    UcPropertiesMapper ucPropertiesMapper;

    @CjTransaction
    @Override
    public String get(String key) {
        UcPropertiesExample example = new UcPropertiesExample();
        example.createCriteria().andPropKeyEqualTo(key);
        List<UcProperties> props = ucPropertiesMapper.selectByExample(example);
        if (props == null || props.isEmpty()) {
            return null;
        }
        return props.get(0).getPropValue();
    }

    @CjTransaction
    @Override
    public void set(String key, String value) {
        UcPropertiesExample example = new UcPropertiesExample();
        example.createCriteria().andPropKeyEqualTo(key);
        ucPropertiesMapper.deleteByExample(example);
        UcProperties prop = new UcProperties();
        prop.setPropId(UUID.randomUUID().toString());
        prop.setPropKey(key);
        prop.setPropValue(value);
        ucPropertiesMapper.insertSelective(prop);
    }

    @CjTransaction
    @Override
    public List<String> keys() {
        UcPropertiesExample example = new UcPropertiesExample();
        example.createCriteria();
        List<UcProperties> props = ucPropertiesMapper.selectByExample(example);
        List<String> list = new ArrayList<>();
        for (UcProperties prop : props) {
            list.add(prop.getPropKey());
        }
        return list;
    }
}
