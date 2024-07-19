package com.mikky.app.rest.domain.models;

import com.mikky.app.rest.domain.enums.OperationTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class BalanceTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserBalance userBalance;

    @Column
    private String transactionType;

    @Column
    private BigDecimal transactionAmount;

    @Column
    private LocalDateTime createdAt;
}
