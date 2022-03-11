package com.kodilla.customers.controller;

import com.kodilla.customers.dto.CustomerDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetCustomerResponse extends CustomerDto {

	public GetCustomerResponse(CustomerDto customerDto) {
		super(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName());
	}
}