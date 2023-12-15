package org.dododo.model.DO;

import lombok.Data;

import java.io.File;

@Data
public class MailDO {
    String to;
    String content;
    String subject;
    File file;
}
