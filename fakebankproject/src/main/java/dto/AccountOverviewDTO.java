package dto;

import lombok.Getter;
import lombok.Setter;
import model.Currency;

import java.math.BigDecimal;

@Setter
@Getter
public class AccountOverviewDTO {
    private String accountNumber;
    private BigDecimal balance;
    private Currency defaultCurrency;
}
