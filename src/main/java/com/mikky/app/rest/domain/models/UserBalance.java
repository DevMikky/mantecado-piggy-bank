package com.mikky.app.rest.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class UserBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    @JsonProperty("nick-name")
    private String nickName;

    @Column
    @JsonProperty("balance")
    private BigDecimal balance;

    @OneToMany(mappedBy = "userBalance")
    private List<BalanceTransaction> balanceTransactions;
}
