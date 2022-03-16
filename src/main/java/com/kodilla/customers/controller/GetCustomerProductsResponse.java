package com.kodilla.customers.controller;

import com.kodilla.customers.dto.AccountDto;
import com.kodilla.customers.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerProductsResponse {
    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;
    private List<CardDto> cards;
}