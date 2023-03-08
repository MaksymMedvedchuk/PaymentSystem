package com.example.paymentsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@ToString
public class Account extends BaseEntity {

    @Column(name = "payment_card")
    private String paymentCard;

    @Column(name = "money_amount")
    private int moneyAmount;

    @ManyToOne(fetch = FetchType.LAZY)//FetchType.LAZY
    @JoinColumn(name = "client")
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Payment> payments;


}
