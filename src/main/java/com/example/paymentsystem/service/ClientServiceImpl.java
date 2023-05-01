package com.example.paymentsystem.service;

import com.example.paymentsystem.model.Client;
import com.example.paymentsystem.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getById(Long id) {
        log.info("IN AccountServiceImpl getById {}", id);
        return clientRepository.findOne(id);
    }

    @Override
    public void save(Client client) {
        log.info("IN AccountServiceImpl save {}", client);
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        log.info("IN AccountServiceImpl delete {}", id);
        clientRepository.delete(id);
    }

    @Override
    public List<Client> getAll() {
        log.info("IN AccountServiceImpl findAll");
        return clientRepository.findAll();
    }
}
