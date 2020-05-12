package com.opensource.OAuthServer;

import com.opensource.OAuthServer.models.OAuthClientModel;
import com.opensource.OAuthServer.repositories.OAuthClientRepository;
import com.opensource.OAuthServer.services.OAuthClientService;
import com.opensource.OAuthServer.services.impl.OAuthClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


@SpringBootApplication
@EnableResourceServer
public class OAuthServerApplication implements CommandLineRunner {

	@Autowired
	private OAuthClientRepository oAuthClientRepo;

	@Autowired
	private OAuthClientService oAuthClientService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OAuthServerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String args[]){
		OAuthClientModel client = new OAuthClientModel("client-app-1",
				"client app 1 description",
				"http://localhost:8080/login/oauth2/code/custom-client");
		client.setClientId("client-app-1");
		client.setClientSecret(passwordEncoder.encode("71CA90701F8EA396CB510883CC93454FC425F1C7F7A17B1487D751A7B5BF1173"));
		client.setResourceIds("resources");
		client.setScopes("read,write");
		oAuthClientRepo.save(client);
	}

}
