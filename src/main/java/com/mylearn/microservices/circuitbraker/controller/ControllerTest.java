package com.mylearn.microservices.circuitbraker.controller;

import com.mylearn.microservices.circuitbraker.vo.Account;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@RequestMapping("/get")
public class ControllerTest {

    @Autowired
    private WebClient webClient;

    @GetMapping("/getAccount/{id}")
    @CircuitBreaker(name="accountService",fallbackMethod = "getBackUpAccount")
    public Account getAccount(@PathVariable String id)
    {
        return webClient.get().uri("/account/"+id).retrieve().bodyToMono(Account.class).block();
    }

    public Account getBackUpAccount(Exception e)
    {
      return new Account(new BigInteger
              ("1"),"Current","Sonali",new BigDecimal("12.00"),1);

    }
}
