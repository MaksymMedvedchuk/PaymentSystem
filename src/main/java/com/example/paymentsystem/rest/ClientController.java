package com.example.paymentsystem.rest;


import com.example.paymentsystem.model.Client;
import com.example.paymentsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable(name = "clientId") Long clientId) {
        Client client = clientService.getById(clientId);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        clientService.save(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable(name = "clientId") Long clientId) {
        boolean deleted = clientService.delete(clientId);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAll(){
        List<Client> clients = clientService.getAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
