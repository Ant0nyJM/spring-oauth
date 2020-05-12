package com.opensource.OAuthServer.controllers;

import com.opensource.OAuthServer.models.OAuthClientModel;
import com.opensource.OAuthServer.repositories.OAuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oauth_client")
public class OAuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OAuthClientRepository oAuthClientRepo;

    @PostMapping("/register")
    public ResponseEntity registerClient(@RequestBody OAuthClientModel newClient){
        newClient.setClientSecret(passwordEncoder.encode(newClient.getClientId()));
        oAuthClientRepo.save(newClient);
        return new ResponseEntity(newClient, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllClients(){
        List<OAuthClientModel> clients = oAuthClientRepo.findAll();
        return new ResponseEntity(clients, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity getAllClients(@PathVariable("id") String clientId){

        Optional<OAuthClientModel> client = oAuthClientRepo.findByClientId(clientId);
        if(client.isPresent()){
            return new ResponseEntity(client, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
}
