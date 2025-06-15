package org.fakebankproject.fakebankproject.dto.responseDTOs.account;

import org.fakebankproject.fakebankproject.model.Currency;

import java.math.BigDecimal;


public class AccountOverviewDTO {
    private String accountNumber;
    private BigDecimal balance;
    private Currency defaultCurrency;
}
