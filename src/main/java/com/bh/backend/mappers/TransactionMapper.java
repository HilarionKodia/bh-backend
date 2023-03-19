package com.bh.backend.mappers;

import com.bh.backend.entities.Transaction;
import com.bh.backend.models.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TransactionMapper {
    TransactionDTO toTransactionDTO (Transaction transaction);
    Transaction toTransaction (TransactionDTO transactionDTO);
    List<TransactionDTO> toTransactionDTOList(List<Transaction> transactionList);
    List<Transaction> toTransactionList(List<TransactionDTO> transactionDTOList);
}
