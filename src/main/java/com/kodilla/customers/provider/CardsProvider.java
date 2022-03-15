package com.kodilla.customers.provider;

import com.kodilla.customers.connector.CardConnector;
import com.kodilla.customers.dto.CardDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsProvider {

    private final CardConnector cardConnector;

    @HystrixCommand(fallbackMethod = "fallBackGetCards")
    public List<CardDto> getCustomerCards(Long customerId) {
        return cardConnector.getCustomerCards(customerId).getCards();
    }

    private List<CardDto> fallBackGetCards(Long customerId) {
        return Collections.emptyList();
    }
}