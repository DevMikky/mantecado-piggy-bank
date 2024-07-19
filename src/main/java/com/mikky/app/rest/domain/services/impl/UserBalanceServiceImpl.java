package com.mikky.app.rest.domain.services.impl;

import com.mikky.app.rest.domain.models.UserBalance;
import com.mikky.app.rest.domain.services.UserBalanceService;
import com.mikky.app.rest.domain.services.error.UserkBalanceException;
import com.mikky.app.rest.infraestructure.repository.UserBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    private final UserBalanceRepository userBalanceRepository;

    @Autowired
    public UserBalanceServiceImpl(UserBalanceRepository userBalanceRepository) {
        this.userBalanceRepository = userBalanceRepository;
    }

    @Override
    public List<UserBalance> getAllUserBalance() {

        try {
            return userBalanceRepository.findAll();
        } catch (DataIntegrityViolationException e) {
            throw new UserkBalanceException(e.getMessage());
        }
    }

    @Override
    public UserBalance getUserBalance(Long balanceId) {
        return userBalanceRepository.findById(balanceId)
                .orElseThrow(() -> new UserkBalanceException(
                        "PiggyBank Balance Not Found for id: " + balanceId));
    }

    @Override
    public String addUserBalance(UserBalance userBalance) {

        try {
            userBalanceRepository.save(userBalance);
        } catch (DataIntegrityViolationException e) {
            throw new UserkBalanceException(e.getMessage());
        }

        return "User balance added";
    }

    @Override
    public String updateUserBalance(Long balanceId,
                                    UserBalance userBalanceRequest) {

        try {
            UserBalance userBalanceToUpdate = userBalanceRepository.findById(balanceId)
                    .orElseThrow(() -> new UserkBalanceException(
                            "PiggyBank Balance Not Found for id: " + balanceId));

            userBalanceToUpdate.setNickName(userBalanceRequest.getNickName());
            userBalanceToUpdate.setBalance(userBalanceRequest.getBalance());

            userBalanceRepository.save(userBalanceToUpdate);

        } catch (DataIntegrityViolationException e) {
            throw new UserkBalanceException(e.getMessage());
        }

        return "User balance updated";
    }
}
