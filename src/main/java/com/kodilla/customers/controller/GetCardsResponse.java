package com.kodilla.customers.controller;

import com.kodilla.customers.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetCardsResponse {

    public List<CardDto> cards;

}