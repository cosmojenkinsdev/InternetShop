package com.company;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.enums.PaymentCategory;
import com.company.instruments.BonusAccount;
import com.company.instruments.CorporateCard;
import com.company.person.Owner;
import com.company.record.OperationRecord;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CorporateCard card = new CorporateCard("023", new Owner("Vadim Ivanovich", "010"), InstrumentStatus.ACTIVE, 1000, 5000 );
        System.out.println(card.pay(new PaymentRequest(500.0, PaymentCategory.FOOD, "001")));

        CorporateCard card2 = new CorporateCard("024", new Owner("Vadim Petrovich", "011"), InstrumentStatus.BLOCK, 4000, 5000 );
        System.out.println(card2.pay(new PaymentRequest(50000.0, PaymentCategory.FOOD, "001")));

        BonusAccount bonusAccount = new BonusAccount("023", new Owner("Fedor Olegovich", "001"), InstrumentStatus.ACTIVE, 1000);
        System.out.println(bonusAccount.getOwner().getName() + " " + bonusAccount.pay(new PaymentRequest(500.0, PaymentCategory.ADS, "001")));

        OperationRecord record = new OperationRecord("1", LocalDateTime.now(), );
    }
}
