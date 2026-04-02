package com.company;

import com.company.dto.PaymentRequest;
import com.company.enums.InstrumentStatus;
import com.company.enums.PaymentCategory;
import com.company.instruments.BonusAccount;
import com.company.instruments.CorporateCard;
import com.company.person.Owner;
import com.company.person.OwnerRegistry;

import static com.company.record.OperationJournal.printHistory;
import static com.company.person.OwnerRegistry.getOrCreateOwner;

public class Main {
    public static void main(String[] args) {

        Owner owner = getOrCreateOwner("CL-100", "Vadim Ivanovich");
        CorporateCard card = new CorporateCard("023", owner, InstrumentStatus.ACTIVE, 1000, 5000);
        System.out.println(card.pay(new PaymentRequest(500.0, PaymentCategory.FOOD)));

        CorporateCard card2 = new CorporateCard("024", getOrCreateOwner("CL-100", "Vadim Ivanovich"), InstrumentStatus.BLOCK, 4000, 5000);
        System.out.println(card2.pay(new PaymentRequest(50000.0, PaymentCategory.FOOD)));

        BonusAccount bonusAccount = new BonusAccount("023", OwnerRegistry.getOrCreateOwner("CL-101", "Fedor Ivanovich"), InstrumentStatus.ACTIVE, 1000);
        System.out.println(bonusAccount.getOwner().getName() + " " + bonusAccount.pay(new PaymentRequest(500.0, PaymentCategory.ADS)));

        Owner owner1 = OwnerRegistry.getOrCreateOwner("CL-102", "Inokentiy Smoktunovskiy");
        BonusAccount bonusAccount2 = new BonusAccount("023", owner1, InstrumentStatus.ACTIVE, 1000);
        System.out.println(bonusAccount2.getOwner().getName() + " " + bonusAccount2.pay(new PaymentRequest(500.0, PaymentCategory.ADS)));

        printHistory();
    }
}
