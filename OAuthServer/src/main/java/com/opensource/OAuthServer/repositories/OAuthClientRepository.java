package com.opensource.OAuthServer.repositories;

import com.opensource.OAuthServer.models.OAuthClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuthClientRepository extends JpaRepository<OAuthClientModel, Long> {

    public Optional<OAuthClientModel> findByClientId(String clientId);
}
