package com.company.instruments;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.enums.PaymentCategory;
import com.company.person.Owner;

import java.util.ArrayList;
import java.util.List;

public class BonusAccount extends PaymentInstrument {
    private List<PaymentCategory> badCategory = new ArrayList<>();

    public BonusAccount(String id, Owner owner, InstrumentStatus status, int balance) {
        super(id, owner, status, balance);
    }

    @Override
    protected String validatePayment(PaymentRequest request) {
        return "";
    }

    @Override
    protected double calculateCommission(PaymentRequest request) {
        return 0;
    }
}
