package com.company.dto;

import com.company.enums.OperationStatus;

public record PaymentResult(OperationStatus status, String message, double requestedMoney, double commission,
                            double withdrawnMoney) {
    public PaymentResult {
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
    }

    @Override
    public String toString() {
        return "Результат оплаты: " +
                "Статус=" + status +
                ", Причина='" + message + '\'' +
                ", Запрошено=" + requestedMoney + " руб" +
                ", Комиссия=" + commission + " руб" +
                ", Списано=" + withdrawnMoney + " руб";
    }
}
