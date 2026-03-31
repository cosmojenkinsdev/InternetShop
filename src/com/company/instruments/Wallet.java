package com.company.instruments;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.person.Owner;

public class Wallet extends PaymentInstrument {
    private int frozenAmount;

    public Wallet(String id, Owner owner, InstrumentStatus status, int balance, int frozenAmount) {
        super(id, owner, status, balance);

    }

    @Override
    protected String validatePayment(PaymentRequest request) {
        return null;
    }

    @Override
    protected double calculateCommission(PaymentRequest request) {
        return 0;
    }

    @Override
    protected double getAvailableBalance() {
        return super.getBalance() - frozenAmount;
    }

    public int getFrozenAmount() {
        return frozenAmount;
    }

}
