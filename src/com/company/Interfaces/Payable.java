package com.company.Interfaces;

import com.company.PaymentRequest;
import com.company.PaymentResult;

public interface Payable {
    PaymentResult payResult(PaymentRequest request);
}
