package com.example.paymentsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@ToString
public class Payment extends BaseEntity {

    @Column(name = "payment")
    private String payment;

    @Column(name = "order_amount")
    private int orderAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    @JsonBackReference
    private Account account;
}
