package com.mikky.app.rest.domain.services;

import com.mikky.app.rest.domain.models.UserBalance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface UserBalanceService {

    List<UserBalance> getAllUserBalance();

    UserBalance getUserBalance(@PathVariable("balanceId") Long balanceId);

    String addUserBalance(@RequestBody UserBalance userBalance);

    String updateUserBalance(@RequestHeader("balance-id") Long balanceId,
                             @RequestBody UserBalance userBalanceRequest);

}