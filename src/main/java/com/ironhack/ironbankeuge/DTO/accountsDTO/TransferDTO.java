package com.ironhack.ironbankeuge.DTO.accountsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class TransferDTO {
    private String usernameDestination;
    private String secretKey;
}
