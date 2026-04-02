package com.company.dto;

import com.company.enums.PaymentCategory;
import com.company.instruments.PaymentInstrument;
import com.company.interfaces.PaymentRule;

import java.util.List;

public class PaymentRuleRegistry {
    private static final List<PaymentRule> tempRules = List.of(
            new PaymentRule() {
                @Override
                public String validate(PaymentInstrument instrument, PaymentRequest request) {
                    String message = "Лимит на оплату рекламы до 3000 руб";
                    if (request.getCategory() == PaymentCategory.ADS && request.getMoney() > 3000) {
                        return message;
                    }
                    return null;
                }
            }
    );

    public List<PaymentRule> getPaymentRules() {
        return tempRules;
    }
}
