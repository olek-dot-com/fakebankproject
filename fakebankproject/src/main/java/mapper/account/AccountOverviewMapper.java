package mapper.account;

import dto.responseDTOs.account.AccountOverviewDTO;
import model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountOverviewMapper {
    AccountOverviewDTO toDTO(Account account);
    Account toEntity(AccountOverviewDTO accountOverviewDTO);
}
