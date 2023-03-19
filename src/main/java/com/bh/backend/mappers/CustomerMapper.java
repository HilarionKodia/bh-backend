package com.bh.backend.mappers;

import com.bh.backend.entities.Customer;
import com.bh.backend.models.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {
    CustomerDTO toCustomerDTO (Customer customer);
    Customer toCustomer (CustomerDTO customerDTO);
    List<CustomerDTO> toCustomerDTOList(List<Customer> customerList);
    List<Customer> toCustomerList(List<CustomerDTO> customerDTOList);
}
