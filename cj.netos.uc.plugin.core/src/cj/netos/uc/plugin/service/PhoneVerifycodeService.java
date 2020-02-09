package cj.netos.uc.plugin.service;

import cj.netos.uc.model.PhoneVerifycode;
import cj.netos.uc.model.PhoneVerifycodeExample;
import cj.netos.uc.plugin.mapper.PhoneVerifycodeMapper;
import cj.netos.uc.service.IPhoneVerifycodeService;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjService(name = "phoneVerifycodeService")
public class PhoneVerifycodeService implements IPhoneVerifycodeService {
    @CjServiceRef(refByName = "mybatis.cj.netos.uc.plugin.mapper.PhoneVerifycodeMapper")
    PhoneVerifycodeMapper phoneVerifycodeMapper;

    @CjTransaction
    @Override
    public String get(String person) {
        PhoneVerifycodeExample example = new PhoneVerifycodeExample();
        example.createCriteria().andPersonEqualTo(person);
        List<PhoneVerifycode> list = phoneVerifycodeMapper.selectByExample(example);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0).getVerifycode();
    }

    @CjTransaction
    @Override
    public void set(String person, String verifycode) {
        PhoneVerifycodeExample example = new PhoneVerifycodeExample();
        example.createCriteria().andPersonEqualTo(person);
        phoneVerifycodeMapper.deleteByExample(example);
        PhoneVerifycode phoneVerifycode = new PhoneVerifycode();
        phoneVerifycode.setPerson(person);
        phoneVerifycode.setVerifycode(verifycode);
        phoneVerifycodeMapper.insertSelective(phoneVerifycode);
    }
}
