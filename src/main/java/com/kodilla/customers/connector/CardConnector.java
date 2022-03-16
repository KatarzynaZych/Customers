package com.kodilla.customers.connector;

import com.kodilla.customers.controller.GetCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardConnector {

    @GetMapping("v1/card/customer/{customerId}")
    GetCardsResponse getCustomerCards(@RequestParam("customerId") Long customerId);
}

@Slf4j
@Component
class CardsConnectorFallback implements CardConnector {

    @Override
    public GetCardsResponse getCustomerCards(Long customerId) {
        log.warn("Can not get cards for customer id: {}", customerId);
        return GetCardsResponse.of(Collections.emptyList());
    }
}
