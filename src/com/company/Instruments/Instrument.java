package com.company.Instruments;

import com.company.Status.InstrumentStatus;

public abstract class Instrument {
    private String id;
    private final String nameHost;
    private InstrumentStatus instrumentStatus;
    private int balance;

    public Instrument(String id, String nameHost, InstrumentStatus instrumentStatus, int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance cannot be less than zero");
        } else if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null");
        } else if (nameHost == null || nameHost.isBlank()) {
            throw new IllegalArgumentException("name host must be");
        } else if (instrumentStatus == InstrumentStatus.BLOCK) {
            throw new IllegalArgumentException("Status must be valid");
        } else {
            this.id = id;
            this.nameHost = nameHost;
            this.instrumentStatus = instrumentStatus;
            this.balance = balance;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameHost() {
        return nameHost;
    }

    public InstrumentStatus getStatus() {
        return instrumentStatus;
    }

    public void setStatus(InstrumentStatus instrumentStatus) {
        this.instrumentStatus = instrumentStatus;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
