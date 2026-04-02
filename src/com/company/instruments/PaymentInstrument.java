package com.company.instruments;

import com.company.dto.PaymentRequest;
import com.company.dto.PaymentResult;
import com.company.enums.InstrumentStatus;
import com.company.enums.OperationStatus;
import com.company.person.Owner;
import com.company.record.OperationRecord;

import java.time.LocalDateTime;

import static com.company.record.OperationJournal.addRecord;

public abstract class PaymentInstrument {
    private final String id;
    private final Owner owner;
    private InstrumentStatus status;
    private double balance;

    public PaymentInstrument(String id, Owner owner, InstrumentStatus status, int balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id инструмента не должен быть пустым");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner инструмента не должен быть null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Статус инструмента не должен быть null");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс инструмента не должен быть отрицательным");
        }
        this.id = id;
        this.owner = owner;
        this.status = status;
        this.balance = balance;
    }

    public final PaymentResult pay(PaymentRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Запрос не может быть null");
        }
        if (getStatus() != InstrumentStatus.ACTIVE) {
            String message = "Статус инструмента не активен";
            PaymentResult result = new PaymentResult(
                    OperationStatus.REJECTED,
                    message,
                    request.getMoney(),
                    0,
                    0);
            OperationRecord record = new OperationRecord(
                    request.getOperationId(),
                    LocalDateTime.now(),
                    getOwner(),
                    request.getMoney(),
                    request.getCategory(),
                    OperationStatus.REJECTED,
                    message);
            addRecord(record);
            return result;
        }
        String validatePaymentMessage = validatePayment(request);
        if (validatePaymentMessage != null) {
            PaymentResult result = new PaymentResult(
                    OperationStatus.REJECTED,
                    validatePaymentMessage,
                    request.getMoney(),
                    0,
                    0);
            OperationRecord record = new OperationRecord(
                    request.getOperationId(),
                    LocalDateTime.now(),
                    getOwner(),
                    request.getMoney(),
                    request.getCategory(),
                    OperationStatus.REJECTED,
                    validatePaymentMessage);
            addRecord(record);
            return result;
        }
        double totalWithdrawnAmount = calculateCommission(request) + request.getMoney();
        if (getAvailableBalance() < totalWithdrawnAmount) {
            String message = "На балансе недостаточно денег";
            PaymentResult result = new PaymentResult(
                    OperationStatus.REJECTED,
                    message,
                    request.getMoney(),
                    calculateCommission(request),
                    0);
            OperationRecord record = new OperationRecord(
                    request.getOperationId(),
                    LocalDateTime.now(),
                    getOwner(),
                    request.getMoney(),
                    request.getCategory(),
                    OperationStatus.REJECTED,
                    message);
            addRecord(record);
            return result;
        }
        decreasedBalance(totalWithdrawnAmount);
        String message = "Оплата успешно прошла";
        PaymentResult result = new PaymentResult(
                OperationStatus.SUCCESS,
                message,
                request.getMoney(),
                calculateCommission(request),
                totalWithdrawnAmount);
        OperationRecord record = new OperationRecord(
                request.getOperationId(),
                LocalDateTime.now(),
                getOwner(),
                request.getMoney(),
                request.getCategory(),
                OperationStatus.SUCCESS,
                message);
        addRecord(record);
        return result;
    }

    /**
     * валидация конкретного инструмента, может ли конкретный тип инструмента провести именно этот платеж по своим собственным правилам.
     *
     * @param request
     * @return null / message (причина отказа)
     */
    protected abstract String validatePayment(PaymentRequest request);

    protected abstract double calculateCommission(PaymentRequest request);

    protected double getAvailableBalance() {
        return balance;
    }

    protected void decreasedBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма списания не должна быть отрицательной");
        }
        balance -= amount;
    }

    public String getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public InstrumentStatus getStatus() {
        return status;
    }

    public void setStatus(InstrumentStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Статус инструмента не должен быть null");
        }
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }


}
