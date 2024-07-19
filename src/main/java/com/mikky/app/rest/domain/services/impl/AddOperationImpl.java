package com.mikky.app.rest.domain.services.impl;

import com.mikky.app.rest.domain.enums.OperationTypeEnum;
import com.mikky.app.rest.domain.models.BalanceTransaction;
import com.mikky.app.rest.domain.models.UserBalance;
import com.mikky.app.rest.domain.services.BalanceOperation;
import com.mikky.app.rest.domain.utils.ConstantsUtil;
import com.mikky.app.rest.infraestructure.repository.BalanceTransactionRepository;
import com.mikky.app.rest.infraestructure.repository.UserBalanceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AddOperationImpl implements BalanceOperation {

    private final UserBalanceRepository userBalanceRepository;

    private final BalanceTransactionRepository transactionRepository;

    public AddOperationImpl(UserBalanceRepository userBalanceRepository,
                            BalanceTransactionRepository transactionRepository) {
        this.userBalanceRepository = userBalanceRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public String executeOperation(Long userId) {

        updateBalance(userId);

        return "Adicion de balance realizado exitosamente";
    }

    @Override
    public OperationTypeEnum getOperationType() {

        return OperationTypeEnum.ADD;
    }

    private void updateBalance(Long userId) {

        UserBalance userBalance = userBalanceRepository.findById(userId).get();

        BigDecimal newBalance = userBalance.getBalance().add(ConstantsUtil.ADD_SUBTRACT_VALUE);

        userBalance.setBalance(newBalance);

        userBalanceRepository.save(userBalance);

        registerOperation(userBalance);
    }

    private void registerOperation(UserBalance userBalance) {

        BalanceTransaction transaction = new BalanceTransaction();
        transaction.setTransactionAmount(ConstantsUtil.ADD_SUBTRACT_VALUE);
        transaction.setTransactionType(getOperationType().toString());
        transaction.setUserBalance(userBalance);
        transaction.setCreatedAt(LocalDateTime.now());

        transactionRepository.save(transaction);
    }
}
