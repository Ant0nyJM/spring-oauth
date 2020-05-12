package com.opensource.OAuthServer.services.impl;

import com.opensource.OAuthServer.models.OAuthClientModel;
import com.opensource.OAuthServer.repositories.OAuthClientRepository;
import com.opensource.OAuthServer.services.OAuthClientService;
import com.opensource.OAuthServer.utils.BytesToHex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
@Service
public class OAuthClientServiceImpl implements OAuthClientService {

    @Autowired
    private OAuthClientRepository oAuthClientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private SecureRandom secureRandom;


    public OAuthClientServiceImpl(){
        this.secureRandom = new SecureRandom();
    }

    public OAuthClientModel createClient(String clientName, String clientDescription, String redirectUris){

        OAuthClientModel client = new OAuthClientModel(clientName, clientDescription, redirectUris);
        client.setClientId(getClientId());
        client.setClientSecret(passwordEncoder.encode(getClientSecret()));
        client.setResourceIds("resources");
        client.setScopes("read,write");
        return oAuthClientRepository.save(client);
    }

    private String getClientId(){

        byte clientId[] = new byte[16];
        this.secureRandom.nextBytes(clientId);
        String clientIdStr = BytesToHex.bytesToHex(clientId);
        if(oAuthClientRepository.findByClientId(clientIdStr).isPresent()){
            return getClientId();
        }
        else{
            return clientIdStr;
        }

    }

    private String getClientSecret() {
        byte[] clientSecret = new byte[32];
        this.secureRandom.nextBytes(clientSecret);
        String clientSecretStr = BytesToHex.bytesToHex(clientSecret);
        return clientSecretStr;
    }


}
