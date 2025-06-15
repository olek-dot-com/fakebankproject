package org.fakebankproject.fakebankproject.mapper.account;

import org.fakebankproject.fakebankproject.dto.responseDTOs.account.AccountOverviewDTO;
import org.fakebankproject.fakebankproject.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountOverviewMapper {
    AccountOverviewDTO toDTO(Account account);
    Account toEntity(AccountOverviewDTO accountOverviewDTO);
}
