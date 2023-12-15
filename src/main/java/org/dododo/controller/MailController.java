package org.dododo.controller;

import org.dododo.service.MailService;
import org.dododo.model.DO.MailDO;
import org.dododo.model.VO.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    Logger logger = LoggerFactory.getLogger(MailController.class);

    final
    MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("mail/send")
    public ResultVO<?> sendMail(@RequestBody MailDO mail) {
       try {
           mailService.sendMail(mail);
       } catch (Exception exception) {
           logger.error("error exception: {}", exception.getMessage());
           return ResultVO.error(exception.getMessage());
       }
       return ResultVO.ok();
    }

    @PostMapping("mail/delete")
    public ResultVO<?> deleteMail(@RequestBody MailDO mail) {
        try {
            mailService.deleteMail(mail.getSubject());
        } catch (Exception exception) {
            logger.error("error exception: {}", exception.getMessage());
            return ResultVO.error(exception.getMessage());
        }
        return ResultVO.ok();
    }
}
