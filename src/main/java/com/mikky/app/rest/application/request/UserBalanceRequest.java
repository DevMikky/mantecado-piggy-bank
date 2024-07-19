package com.mikky.app.rest.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBalanceRequest {

    @JsonProperty("nickname")
    private String nickName;

    @JsonProperty("balance")
    private BigDecimal balance;
}
