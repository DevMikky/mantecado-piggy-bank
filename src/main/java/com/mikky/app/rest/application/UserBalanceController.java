package com.mikky.app.rest.application;

import com.mikky.app.rest.application.request.UserBalanceRequest;
import com.mikky.app.rest.application.response.UserBalanceResponse;
import com.mikky.app.rest.domain.models.UserBalance;
import com.mikky.app.rest.domain.services.UserBalanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-balance")
public class UserBalanceController {

    private final UserBalanceService userBalanceService;

    public UserBalanceController(UserBalanceService userBalanceService) {
        this.userBalanceService = userBalanceService;
    }

    @GetMapping("")
    public List<UserBalanceResponse> getAllUserBalance() {

        return userBalanceService.getAllUserBalance();
    }

    @GetMapping("/{balanceId}")
    public UserBalanceResponse getUserBalance(@PathVariable Long balanceId) {
        return userBalanceService.getUserBalance(balanceId);
    }

    @PostMapping("")
    public String addUserBalance(@RequestBody UserBalanceRequest userBalanceRequest) {
        return userBalanceService.addUserBalance(userBalanceRequest);
    }

    @PutMapping("")
    public String updateUserBalance(@RequestHeader("balance-id") Long balanceId,
                                    @RequestBody UserBalanceRequest userBalanceRequest) {

        return userBalanceService.updateUserBalance(balanceId, userBalanceRequest);
    }
}
