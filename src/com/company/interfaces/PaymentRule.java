package com.company.interfaces;

import com.company.dto.PaymentRequest;

@FunctionalInterface
public interface PaymentRule {
    String validate(PaymentRequest request);
}
