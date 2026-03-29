package com.company.dto;

import com.company.enums.OperationStatus;

public final class PaymentResult {
    private final OperationStatus status;
    private final String message;
    private final double requestedMoney;
    private final double commission;
    private final double withdrawnMoney;

    public PaymentResult(OperationStatus status, String message, double requestedMoney, double commission, double withdrawnMoney) {
        if (status == null) {
            throw new IllegalArgumentException("Статус операции не может равняться null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Нужно указать результат операции");
        }
        if (requestedMoney < 0) {
            throw new IllegalArgumentException("Запрошенная сумма на оплату не должна быть меньше 0");
        }
        if (commission < 0) {
            throw new IllegalArgumentException("Комиссия не должна быть отрицательна");
        }
        if (withdrawnMoney < 0) {
            throw new IllegalArgumentException("Списание денежных средств не должно быть меньше 0");
        }
        this.status = status;
        this.message = message;
        this.requestedMoney = requestedMoney;
        this.commission = commission;
        this.withdrawnMoney = withdrawnMoney;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public double getRequestedMoney() {
        return requestedMoney;
    }

    public double getCommission() {
        return commission;
    }

    public double getWithdrawnMoney() {
        return withdrawnMoney;
    }
}
