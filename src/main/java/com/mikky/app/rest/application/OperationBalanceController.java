package com.mikky.app.rest.application;

import com.mikky.app.rest.domain.enums.OperationTypeEnum;
import com.mikky.app.rest.domain.services.OperationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operation-balance")
public class OperationBalanceController {

    @Autowired
    OperationFactory operationFactory;

    @PostMapping("")
    public String operationBalance(
            @RequestHeader("user-id") Long userId,
            @RequestHeader("operation-type") OperationTypeEnum operationType) {

        return operationFactory.getOperationType(operationType).executeOperation(userId);
    }

}
