package com.company.dto;

import com.company.enums.PaymentCategory;

public record PaymentRequest(double money, PaymentCategory category, String operationId) {
    public PaymentRequest {
        if (money <= 0) {
            throw new IllegalArgumentException("Сумма должна быть выше 0");
        }
        if (operationId == null || operationId.isBlank()) {
            throw new IllegalArgumentException("У транзакции должны быть id");
        }
        if (category == null) {
            throw new IllegalArgumentException("Вы не ввели категорию про транзакции");
        }
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
