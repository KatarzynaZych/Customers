package com.kodilla.customers.controller;

import com.kodilla.customers.dto.CustomerDto;
import com.kodilla.customers.model.Customer;
import com.kodilla.customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/")
@RequiredArgsConstructor
public class CustomersController {

    @Value("${application.allow-get-customers}")
    private boolean allowGetCustomers;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    DataSource dataSource;

    @GetMapping("/customer/{idCustomer}")
    public GetCustomerResponse getCustomerAccounts(@PathVariable Long idCustomer) {
        if (!allowGetCustomers) {
            log.info("GETTING CUSTOMERS IS DISABLED");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }

        return new GetCustomerResponse(convertToDto(customerRepository.findById(idCustomer).orElseThrow()));
    }

    private CustomerDto convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }
}
