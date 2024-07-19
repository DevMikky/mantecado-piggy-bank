package com.mikky.app.rest.domain.services;

import com.mikky.app.rest.domain.enums.OperationTypeEnum;
import org.springframework.web.bind.annotation.RequestHeader;

import java.math.BigDecimal;

public interface BalanceOperation {

    String executeOperation(@RequestHeader Long userId);

    OperationTypeEnum getOperationType();
}
