package com.company.dto;

import com.company.enums.PaymentCategory;
import com.company.instruments.PaymentInstrument;
import com.company.interfaces.PaymentRule;

import java.util.List;

public class PaymentRuleRegistry {
    private static final List<PaymentRule> tempRules = List.of(
            ((request) -> {
                if (request.getCategory() == PaymentCategory.ADS && request.getMoney() > 3000) {
                    return "Лимит на оплату рекламы до 3000 руб";
                }
                return null;
            }
            ));

    public static List<PaymentRule> getPaymentRules() {
        return tempRules;
    }
}
