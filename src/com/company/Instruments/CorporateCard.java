package com.company.Instruments;

import com.company.Interfaces.Payable;
import com.company.PaymentRequest;
import com.company.PaymentResult;
import com.company.Status.InstrumentStatus;

public class CorporateCard extends Instrument implements Payable {
    public CorporateCard(String id, String nameHost, InstrumentStatus instrumentStatus, int balance) {
        super(id, nameHost, instrumentStatus, balance);
    }

    @Override
    public PaymentResult payResult(PaymentRequest request) {

        return result;
    }
}
