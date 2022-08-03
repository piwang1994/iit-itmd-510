package controller;

import records.BankRecords;

import java.io.Serializable;
import java.util.HashMap;

public class BankRecordSerialObject implements Serializable {
    private static final long serialVersionUID = 1L;
    HashMap<Long, BankRecords> BRmap;

    public BankRecordSerialObject(HashMap<Long, BankRecords> map) {
        this.BRmap = map;

    }


}
