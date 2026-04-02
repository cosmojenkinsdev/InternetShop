package com.company.record;

import com.company.enums.OperationStatus;
import com.company.enums.PaymentCategory;
import com.company.person.Owner;

import java.time.LocalDateTime;

public class OperationRecord {
    private final String operationId;
    private final LocalDateTime time;
    private final double money;
    private final PaymentCategory category;
    private final OperationStatus status;
    private final String message;
    private final Owner owner;

    public OperationRecord(String operationId, LocalDateTime time, Owner owner, double money, PaymentCategory category, OperationStatus status, String message) {
        if (operationId == null || operationId.isBlank()) {
            throw new IllegalArgumentException("Operation id не должен быть пустым");
        }
        if (time == null) {
            throw new IllegalArgumentException("Время операции не должно быть null");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Сумма операции не должна быть отрицательной");
        }
        if (category == null) {
            throw new IllegalArgumentException("Категория операции не должна быть null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Статус операции не должен быть null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Сообщение операции не должно быть пустым");
        }
        this.operationId = operationId;
        this.time = time;
        this.owner = owner;
        this.money = money;
        this.category = category;
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "OperationRecord{" +
                "operationId='" + operationId + '\'' +
                ", time=" + time +
                ", owner=" + owner +
                ", money=" + money +
                ", category=" + category +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
