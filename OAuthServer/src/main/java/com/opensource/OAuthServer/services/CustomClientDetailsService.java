package com.opensource.OAuthServer.services;

import com.opensource.OAuthServer.models.OAuthClientModel;
import com.opensource.OAuthServer.repositories.OAuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;


//
@Service
public class CustomClientDetailsService implements ClientDetailsService {

    @Autowired
    private OAuthClientRepository oAuthClientRepo;

    @Override
    public ClientDetails loadClientByClientId(String clientId){
        Optional<OAuthClientModel> optClient = oAuthClientRepo.findByClientId(clientId);
        if(optClient.isPresent()){
            OAuthClientModel client = optClient.get();

            // TODO implement authorities
            BaseClientDetails baseClient = new BaseClientDetails(client.getClientId(), client.getResourceIds(),client.getScopes(), client.getAuthorizedGrantTypes(), "", client.getRedirectUri());
            baseClient.setClientSecret(client.getClientSecret());
            baseClient.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
            baseClient.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
            return baseClient;
        }
        else{
            return null;
        }
    }
}
