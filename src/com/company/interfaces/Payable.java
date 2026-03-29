package com.company.interfaces;

import com.company.dto.PaymentRequest;
import com.company.dto.PaymentResult;

public interface Payable {
    PaymentResult payResult(PaymentRequest request);
}
