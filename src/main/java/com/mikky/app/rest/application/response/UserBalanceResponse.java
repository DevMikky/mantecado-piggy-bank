package com.mikky.app.rest.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBalanceResponse {

    @JsonProperty("user-id")
    private Long userId;

    @JsonProperty("nick-name")
    private String nickName;

    @JsonProperty("balance")
    private BigDecimal balance;
}
