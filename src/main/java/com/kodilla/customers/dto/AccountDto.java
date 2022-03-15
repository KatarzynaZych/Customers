package com.kodilla.customers.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
	private long id;
	private String nrb;
	private String currency;
	private BigDecimal availableFunds;

}