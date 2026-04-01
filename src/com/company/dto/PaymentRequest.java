package com.company.dto;

import com.company.enums.PaymentCategory;

public final class PaymentRequest {
    private final double money;
    private final PaymentCategory category;
    private final String operationId;

    public PaymentRequest(double money, PaymentCategory category, String operationId) {
        if (money <= 0) {
            throw new IllegalArgumentException("Сумма должна быть выше 0");
        }
        if (operationId == null || operationId.isBlank()) {
            throw new IllegalArgumentException("У транзакции должны быть id");
        }
        if (category == null) {
            throw new IllegalArgumentException("Вы не ввели категорию про транзакции");
        }
        this.money = money;
        this.category = category;
        this.operationId = operationId;
    }

    public double getMoney() {
        return money;
    }

    public PaymentCategory getCategory() {
        return category;
    }

    public String getOperationId() {
        return operationId;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "money=" + money +
                ", category=" + category +
                ", operationId='" + operationId + '\'' +
                '}';
    }
}
