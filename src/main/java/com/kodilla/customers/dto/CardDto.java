package com.kodilla.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class CardDto {

    private long id;

    private String cardNumber;

    private String cardHolder;

    private Date expirationDate;

}
