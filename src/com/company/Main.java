package com.company;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.enums.PaymentCategory;
import com.company.instruments.BonusAccount;
import com.company.instruments.CorporateCard;
import com.company.person.Owner;

import static com.company.record.OperationJournal.printHistory;

public class Main {
    public static void main(String[] args) {
        CorporateCard card = new CorporateCard("023", new Owner("Vadim Ivanovich"), InstrumentStatus.ACTIVE, 1000, 5000);
        System.out.println(card.pay(new PaymentRequest(500.0, PaymentCategory.FOOD)));

        CorporateCard card2 = new CorporateCard("024", new Owner("Fedor Olegovich"), InstrumentStatus.BLOCK, 4000, 5000);
        System.out.println(card2.pay(new PaymentRequest(50000.0, PaymentCategory.FOOD)));

        BonusAccount bonusAccount = new BonusAccount("023", new Owner("Andrew Ivanovich"), InstrumentStatus.ACTIVE, 1000);
        System.out.println(bonusAccount.getOwner().getName() + " " + bonusAccount.pay(new PaymentRequest(500.0, PaymentCategory.ADS)));

        BonusAccount bonusAccount2 = new BonusAccount("023", new Owner("Petr Petrovich"), InstrumentStatus.ACTIVE, 1000);
        System.out.println(bonusAccount2.getOwner().getName() + " " + bonusAccount2.pay(new PaymentRequest(500.0, PaymentCategory.ADS)));

        printHistory();
    }
}
