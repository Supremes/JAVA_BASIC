package org.dododo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EatingData {
    private Date date;
    private String consumeType;
    private String incoming;
    private String expendNumber;
    private String comments;
    private String expendPerson;
}
