package com.company.instruments;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.person.Owner;

public class CorporateCard extends PaymentInstrument {
    private final int transactionLimit;
    private static final double COMMISSION_FOR_CARD = 0.02;
    private static int counter = 1;

    public CorporateCard(String id, Owner owner, InstrumentStatus status, int balance, int transactionLimit) {
        super("CARD-" + counter++, owner, status, balance);
        if (transactionLimit <= 0) {
            throw new IllegalArgumentException("Лимит одной операции должен быть больше 0");
        }
        this.transactionLimit = transactionLimit;
    }

    @Override
    protected String validatePayment(PaymentRequest request) {
        if (request.getMoney() > transactionLimit){
            return "Сумма транзакции больше лимита суммы по операциям";
        }
        return null;
    }

    @Override
    protected double calculateCommission(PaymentRequest request) {
        return request.getMoney() * COMMISSION_FOR_CARD;
    }

    public int getTransactionLimit() {
        return transactionLimit;
    }
}
