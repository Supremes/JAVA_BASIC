package org.dododo.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class EatingBill {
    private long id;

    private long familyID;

    private String purchaseThing;

    private Timestamp purchaseTime;
}
