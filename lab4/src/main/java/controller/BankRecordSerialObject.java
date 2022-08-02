package controller;

import records.BankRecords;

import java.io.Serializable;
import java.util.HashMap;

public class BankRecordSerialObject implements Serializable {
    HashMap<Long,BankRecords> BRmap;
    private static final long serialVersionUID= 1L;
    public BankRecordSerialObject(HashMap<Long,BankRecords> map){
        this.BRmap=map;

    }


}
