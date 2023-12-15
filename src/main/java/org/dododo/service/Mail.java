package org.dododo.service;

import org.dododo.model.DO.MailDO;

public interface Mail {
    void sendMail(MailDO mail);
    void deleteMail(String subject) ;
    void sendMailWithAttach(MailDO mail);

}
