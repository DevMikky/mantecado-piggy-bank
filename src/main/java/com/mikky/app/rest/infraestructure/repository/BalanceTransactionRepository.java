package com.mikky.app.rest.infraestructure.repository;

import com.mikky.app.rest.domain.models.BalanceTransaction;
import com.mikky.app.rest.domain.models.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceTransactionRepository extends JpaRepository<BalanceTransaction, Long> {
}
