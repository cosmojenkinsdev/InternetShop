package com.company;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.enums.PaymentCategory;
import com.company.instruments.CorporateCard;
import com.company.person.Owner;

public class Main {
    public static void main(String[] args) {
        CorporateCard card = new CorporateCard("023", new Owner("Vadim Ivanovich", "010"), InstrumentStatus.ACTIVE, 400, 5000 );
        card.pay(new PaymentRequest(500.0, PaymentCategory.FOOD, "001"));

        CorporateCard card2 = new CorporateCard("024", new Owner("Vadim Petrovich", "011"), InstrumentStatus.BLOCK, 4000, 5000 );
        card2.pay(new PaymentRequest(50000.0, PaymentCategory.FOOD, "001"));
    }
}
