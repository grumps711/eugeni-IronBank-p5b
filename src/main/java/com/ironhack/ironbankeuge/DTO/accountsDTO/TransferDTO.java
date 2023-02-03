package com.ironhack.ironbankeuge.DTO.accountsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class TransferDTO {

    private String accountTypeOrigin;
    private String accountTypeDestination;
    private String secretKey;
    private String usernameOrigin;
    private String usernameDestination;
     private Long accountIdOrigin;
     private Long accountIdDestination;
     private BigDecimal amount;
}
