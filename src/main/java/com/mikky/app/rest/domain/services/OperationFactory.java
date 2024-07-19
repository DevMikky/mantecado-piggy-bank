package com.mikky.app.rest.domain.services;

import com.mikky.app.rest.domain.enums.OperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class OperationFactory {

    Map<OperationTypeEnum, BalanceOperation> operationMap;

    @Autowired
    public OperationFactory(Set<BalanceOperation> operationTypeSet) {

        createStrategy(operationTypeSet);
    }

    private void createStrategy(Set<BalanceOperation> operationTypeSet) {

        operationMap = new HashMap<>();

        operationTypeSet
                .forEach(
                        operationType -> operationMap.put(
                                operationType.getOperationType(),
                                operationType
                        )
                );
    }

    public BalanceOperation getOperationType(OperationTypeEnum operationType) {
        return operationMap.get(operationType);
    }
}
