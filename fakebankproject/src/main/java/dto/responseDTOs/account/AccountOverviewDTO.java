package dto.responseDTOs.account;

import model.Currency;

import java.math.BigDecimal;


public class AccountOverviewDTO {
    private String accountNumber;
    private BigDecimal balance;
    private Currency defaultCurrency;
}
