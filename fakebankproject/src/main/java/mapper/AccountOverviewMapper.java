package mapper;

import dto.AccountOverviewDTO;
import model.Account;

public class AccountOverviewMapper {
    public static AccountOverviewDTO toDTO(Account accountOverview) {
        if (accountOverview == null) {
            return null;
        }

        AccountOverviewDTO dto = new AccountOverviewDTO();
        dto.setAccountNumber(accountOverview.getAccountNumber());
        dto.setBalance(accountOverview.getBalance());
        dto.setDefaultCurrency(accountOverview.getDefaultCurrency());
        return dto;
    }


}
