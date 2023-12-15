package org.dododo.service;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import org.dododo.model.DO.MailDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

//
//import javax.mail.*;
//import java.util.Properties;
//import java.util.HashMap;

@Component
public class MailService implements Mail {

    private final Logger logger = LoggerFactory.getLogger(MailService.class);
    final private JavaMailSender sender;

    public MailService(JavaMailSender sender) {
        this.sender = sender;
    }

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private String port;

    @Override
    public void sendMail(MailDO mail) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(username);
            msg.setTo(mail.getTo());
            msg.setSubject(mail.getSubject());
            msg.setText(mail.getContent());

            sender.send(msg);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteMail(String subject) {

    }

//    @Override
//    public void deleteMail(String subject){
//        Properties properties = new Properties();
//        properties.put("mail.store.protocol", "imap");
//        properties.put("mail.host", "imap.163.com");
//        properties.put("mail.smtp.auth", "true");
//        /*
//            问题：A3 NO SELECT Unsafe Login. Please contact kefu@188.com for help
//            意思就是说：这不是一个安全的连接，其实是网易没有遵循IMAP的规范，它强制要求你使用IMAP的ID命令，需要特色添加ID COMMAND
//            方案：https://blog.csdn.net/liuhaibo_ljf/article/details/118413939
//            添加imap的id，然后再去读取邮件就好用了。具体的实现方式如下，我直接放上代码：
//            这部分就是解决异常的关键所在，设置IAMP ID信息
//         */
//        HashMap<String, String> IAM = new HashMap<>();
//        //带上IMAP ID信息，由key和value组成，例如name，version，vendor，support-email等。
//        // 这个value的值随便写就行
//        IAM.put("name","myname");
//        IAM.put("version","1.0.0");
//        IAM.put("vendor","myclient");
//        IAM.put("support-email","testmail@test.com");
//
//        Session session = Session.getInstance(properties);
//        // 使用imap会话机制，连接服务器
//        int total = 0;
//        IMAPStore store = (IMAPStore) session.getStore("imap");
//        store.connect(username, password);
//        store.id(IAM);
//
//        IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX"); // 收件箱
//        folder.open(Folder.READ_WRITE);
//        // 获取总邮件数
//        total = folder.getMessageCount();
//        logger.debug("邮件数目: {}", total);
//
//        Message[] message = folder.getMessages();
//        for (int i = 0; i < message.length; i++)
//            logger.debug("message: {}", message[i].getSubject());
//
//        for (int i = 1; i <= total; i++)
//            logger.debug("message: {}", folder.getMessage(i));
//
//        // 关闭Folder和Store对象
//        folder.close(true);
//        store.close();
//    }

    @Override
    public void sendMailWithAttach(MailDO mail) {

    }
}
