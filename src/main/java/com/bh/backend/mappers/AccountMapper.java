package com.bh.backend.mappers;

import com.bh.backend.entities.Account;
import com.bh.backend.models.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {
    AccountDTO toAccountDTO (Account account);
    Account toAccount (AccountDTO accountDTO);
    List<AccountDTO> toAccountDTOList(List<Account> accountList);
    List<Account> toAccountList(List<AccountDTO> accountDTOList);
}
