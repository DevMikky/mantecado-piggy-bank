package com.mikky.app.rest.domain.services.impl;

import com.mikky.app.rest.application.request.UserBalanceRequest;
import com.mikky.app.rest.application.response.UserBalanceResponse;
import com.mikky.app.rest.domain.models.UserBalance;
import com.mikky.app.rest.domain.services.UserBalanceService;
import com.mikky.app.rest.domain.services.error.UserkBalanceException;
import com.mikky.app.rest.infraestructure.repository.UserBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    private final UserBalanceRepository userBalanceRepository;

    @Autowired
    public UserBalanceServiceImpl(UserBalanceRepository userBalanceRepository) {
        this.userBalanceRepository = userBalanceRepository;
    }

    @Override
    public List<UserBalanceResponse> getAllUserBalance() {

        List<UserBalance> userBalances = userBalanceRepository.findAll();

        List<UserBalanceResponse> userBalanceResponses = new ArrayList<>();
        for (UserBalance userBalance : userBalances) {
            UserBalanceResponse userBalanceResponse = new UserBalanceResponse();
            userBalanceResponse.setBalance(userBalance.getBalance());
            userBalanceResponse.setUserId(userBalance.getUserId());
            userBalanceResponse.setNickName(userBalance.getNickName() );
            userBalanceResponses.add(userBalanceResponse);
        }

        return userBalanceResponses;
    }

    @Override
    public UserBalanceResponse getUserBalance(Long balanceId) {

        UserBalance userBalance = userBalanceRepository.findById(balanceId).orElse(null);

        if (userBalance == null) {
            throw new UserkBalanceException("User not found");
        }

        UserBalanceResponse response = new UserBalanceResponse();
        response.setBalance(userBalance.getBalance());
        response.setUserId(userBalance.getUserId());
        response.setNickName(userBalance.getNickName());

        return response;
    }

    @Override
    public String addUserBalance(UserBalanceRequest userBalanceRequest) {

        try {

            UserBalance userBalance = new UserBalance();
            userBalance.setBalance(userBalanceRequest.getBalance());
            userBalance.setNickName(userBalanceRequest.getNickName());
            userBalanceRepository.save(userBalance);

        } catch (DataIntegrityViolationException e) {
            throw new UserkBalanceException(e.getMessage());
        }

        return "User balance added";
    }

    @Override
    public String updateUserBalance(Long balanceId,
                                    UserBalanceRequest userBalanceRequest) {

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
