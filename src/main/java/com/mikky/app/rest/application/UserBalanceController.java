package com.mikky.app.rest.application;

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
    public List<UserBalance> getAllUserBalance() {

        return userBalanceService.getAllUserBalance();
    }

    @GetMapping("/{balanceId}")
    public UserBalance getUserBalance(@PathVariable Long balanceId) {
        return userBalanceService.getUserBalance(balanceId);
    }

    @PostMapping("")
    public String addUserBalance(@RequestBody UserBalance userBalance) {
        return userBalanceService.addUserBalance(userBalance);
    }

    @PutMapping("")
    public String updateUserBalance(@RequestHeader("balance-id") Long balanceId,
                                    @RequestBody UserBalance userBalanceRequest) {

        return userBalanceService.updateUserBalance(balanceId, userBalanceRequest);
    }
}
