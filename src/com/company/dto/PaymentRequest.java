package com.company.dto;

import com.company.enums.PaymentCategory;

public class PaymentRequest {
    private final double money;
    private final String operationId;
    private static int counter = 1;
    private final PaymentCategory category;

    public PaymentRequest(double money, PaymentCategory category) {
        if (money <= 0) {
            throw new IllegalArgumentException("Сумма должна быть выше 0");
        }
        if (category == null) {
            throw new IllegalArgumentException("Вы не ввели категорию про транзакции");
        }
        this.money = money;
        this.category = category;
        this.operationId = "OPERATION-" + counter++;
    }

    public double getMoney() {
        return money;
    }

    public String getOperationId() {
        return operationId;
    }

    public PaymentCategory getCategory() {
        return category;
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
