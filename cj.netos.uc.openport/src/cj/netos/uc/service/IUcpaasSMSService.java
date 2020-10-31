package cj.netos.uc.service;

import cj.studio.ecm.net.CircuitException;

public interface IUcpaasSMSService {
    String addSmsTemplate(String template_name, String autograph, String content) throws CircuitException;

    String deleterSmsTemplate(String templateid) throws CircuitException;

    String getSmsTemplate(String templateid, String page_num, String page_size) throws CircuitException;

    void sendSms(String param, String mobile, String uid) throws CircuitException;

    void sendSmsInviteNotify(String param, String phone, String uid) throws CircuitException;

}
