package com.mikky.app.rest.domain.services;

import com.mikky.app.rest.application.request.UserBalanceRequest;
import com.mikky.app.rest.application.response.UserBalanceResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface UserBalanceService {

    List<UserBalanceResponse> getAllUserBalance();

    UserBalanceResponse getUserBalance(@PathVariable("balanceId") Long balanceId);

    String addUserBalance(@RequestBody UserBalanceRequest userBalanceRequest);

    String updateUserBalance(@RequestHeader("balance-id") Long balanceId,
                             @RequestBody UserBalanceRequest userBalanceRequest);

}