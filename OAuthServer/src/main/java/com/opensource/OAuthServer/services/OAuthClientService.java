package com.opensource.OAuthServer.services;

import com.opensource.OAuthServer.models.OAuthClientModel;
import com.opensource.OAuthServer.repositories.OAuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public interface OAuthClientService {


    public OAuthClientModel createClient(String clientName, String clientDescription, String redirectUris);
}
