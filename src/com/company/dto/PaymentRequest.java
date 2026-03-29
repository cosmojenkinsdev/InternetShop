package com.company.dto;

import com.company.enums.PaymentCategory;

public class PaymentRequest {
    private double money;
    private PaymentCategory category;
    private String id;

    public PaymentRequest(double money, PaymentCategory category, String id) {
        this.money = money;
        this.category = category;
        this.id = id;
    }
}
