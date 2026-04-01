package com.company.instruments;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.enums.PaymentCategory;
import com.company.person.Owner;

import java.util.List;

public class BonusAccount extends PaymentInstrument {
    private static final List<PaymentCategory> badCategories = List.of(PaymentCategory.ADS, PaymentCategory.TAXI);

    public BonusAccount(String id, Owner owner, InstrumentStatus status, int balance) {
        super(id, owner, status, balance);
    }

    @Override
    protected String validatePayment(PaymentRequest request) {
        if (badCategories.contains(request.category())) {
            return "Эта категория недоступна для оплаты бонусным счетом";
        }
        return null;
    }

    @Override
    protected double calculateCommission(PaymentRequest request) {
        return 0;
    }

    public List<PaymentCategory> getBadCategories() {
        return List.copyOf(badCategories);
    }
}
