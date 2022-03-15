package com.kodilla.customers.provider;

import com.kodilla.customers.connector.AccountsConnector;
import com.kodilla.customers.dto.AccountDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

    @HystrixCommand(fallbackMethod = "fallBackGetAccounts")
    public List<AccountDto> getCustomerAccounts(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                        account.getId(),
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFunds()))
                .collect(Collectors.toList());
    }

    private List<AccountDto> fallBackGetAccounts(Long customerId){
        return Collections.emptyList();
    }
}