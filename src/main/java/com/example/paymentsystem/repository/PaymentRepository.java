package com.example.paymentsystem.repository;

import com.example.paymentsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

//чому тут не ставимо анотацію @Repository, щоб позначити як бін
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
