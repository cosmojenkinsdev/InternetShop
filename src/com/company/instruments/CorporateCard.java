package com.company.instruments;

import com.company.interfaces.Payable;
import com.company.dto.PaymentRequest;
import com.company.dto.PaymentResult;
import com.company.enums.InstrumentStatus;

public class CorporateCard extends Instrument implements Payable {
    public CorporateCard(String id, String nameHost, InstrumentStatus instrumentStatus, int balance) {
        super(id, nameHost, instrumentStatus, balance);
    }

    @Override
    public PaymentResult payResult(PaymentRequest request) {

        return result;
    }
}
