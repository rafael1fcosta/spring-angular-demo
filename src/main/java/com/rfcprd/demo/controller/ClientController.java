package com.rfcprd.demo.controller;

import com.rfcprd.demo.entity.Client;
import com.rfcprd.demo.repo.ClientRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {

    private final ClientRepo clientRepo;

    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @GetMapping("/getClients")
    public List<Client> getClients() {
        return (List<Client>) clientRepo.findAll();
    }

    @PostMapping("/client")
    void addUser(@RequestBody Client client) {
        clientRepo.save(client);
    }
}
