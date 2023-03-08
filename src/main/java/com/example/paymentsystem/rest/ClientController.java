package com.example.paymentsystem.rest;


import com.example.paymentsystem.model.Client;
import com.example.paymentsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//даний клас є контролером, в цьому класі буде реалізована логіка обробки клієнтських запитів
@RequestMapping("/clients/")
public class ClientController {

    @Autowired
    @Qualifier("clientServiceImpl")
    private ClientService clientService;

    @RequestMapping(value = "{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable(name = "clientId") Long clientId) {
        Client client = clientService.getById(clientId);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //ResponseEntity клас для повернення відповіді та HTTP статусу
        //PathVariable для отримання значення нашого URI та передає його в clientId метода
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        clientService.save(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //RequestBody для конвертації тіла запиту в вказаний параметр метода(JSON в Java об'єкт)
    }

    @RequestMapping(value = "{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteClient(@PathVariable(name = "clientId") Long clientId) {
        clientService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
