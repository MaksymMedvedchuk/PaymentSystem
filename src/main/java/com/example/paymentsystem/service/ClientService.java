package com.example.paymentsystem.service;

import com.example.paymentsystem.model.Client;

import java.util.List;

public interface ClientService {

    Client getById(Long id);

    void save(Client client);

    void delete(Long id);

    List<Client> getAll();
}
