package com.company.interfaces;

import com.company.dto.PaymentRequest;
import com.company.instruments.PaymentInstrument;

@FunctionalInterface
public interface PaymentRule {
    String validate(PaymentRequest request);
}
