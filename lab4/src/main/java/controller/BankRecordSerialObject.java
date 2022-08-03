package controller;

import records.BankRecords;
import records.base.Person;

import java.io.Serializable;
import java.util.HashMap;

public class BankRecordSerialObject implements Serializable {
    private static final long serialVersionUID = 1L;
    HashMap<Long, Person> BRmap;

    public BankRecordSerialObject(HashMap<Long, Person> map) {
        this.BRmap = map;

    }


}
