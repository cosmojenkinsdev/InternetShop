package com.company.instruments;

import com.company.enums.InstrumentStatus;
import com.company.person.Owner;
import com.company.record.OperationRecord;

import java.util.ArrayList;

public abstract class PaymentInstrument {
    private final String id;
    private final Owner owner;
    private InstrumentStatus status;
    protected double balance;
    private final ArrayList<OperationRecord> operationRecords;

    public PaymentInstrument(String id, Owner owner, InstrumentStatus status, int balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id инструмента не должен быть пустым");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner инструмента не должен быть null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Статус инструмента не должен быть null");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс инструмента не должен быть отрицательным");
        }
        this.id = id;
        this.owner = owner;
        this.status = status;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public InstrumentStatus getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }


}
