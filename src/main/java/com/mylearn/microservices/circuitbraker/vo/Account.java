package com.mylearn.microservices.circuitbraker.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private BigInteger accountNumber;
    private String accountType;
    private String name;
    private BigDecimal accountBalance;
    private long userId;

}
