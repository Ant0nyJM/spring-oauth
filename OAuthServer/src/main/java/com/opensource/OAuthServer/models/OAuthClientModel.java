package com.opensource.OAuthServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
// https://blog.couchbase.com/oauth-2-dynamic-client-registration/
// TODO seperate tables for scopes, resource_ids ,auth_grant etc
// TODO unique client id, created time and date
@Entity(name = "OAuthClient")
@Table(name = "oauth_client")
public class OAuthClientModel {
    @Id
    @Column(name = "client_id", unique = true)
    @NotNull
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "client_name")
    @NotNull
    private String clientName;

    @Column(name = "client_description")
    private String clientDescription;

    @Column(name = "resource_ids")
    @NotNull
//    private Set<String> resourceIds = new HashSet<>();
    private String resourceIds;

    @Column(name = "secret_required")
    private boolean secretRequired;

    @Column(name = "scoped")
    private boolean scoped;

    @Column(name = "scopes")
    @NotNull
    //private Set<String> scopes = new HashSet<>();
    private String scopes ;

//    @Column(name = "auth_grant_types")
//    private Set<String> authorizedGrantTypes = new HashSet<>();
    @Column(name = "auth_grant_types")
    private String authorizedGrantTypes;

//    @Column(name = "redirect_uris")
//    @NotNull
//    private Set<String> registeredRedirectUri = new HashSet<>();
    @Column(name = "redirect_uri")
    private String redirectUri;

//    @Column(name = "authorities")
//    private Set<String> authorities = new HashSet<>();

    @Column(name = "access_token_validity")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity")
    private  Integer refreshTokenValiditySeconds;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public OAuthClientModel(){}


    public OAuthClientModel(@NotNull String clientName, String clientDescription, @NotNull String registeredRedirectUri) {
        this.clientName = clientName;
        this.clientDescription = clientDescription;
        this.redirectUri = registeredRedirectUri;
        this.setAccessTokenValiditySeconds(60);
        this.setRefreshTokenValiditySeconds(70);
        this.setScoped(true);
        this.setSecretRequired(true);
        this.setAuthorizedGrantTypes("authorization_code,refresh_token");
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription;
    }

//    public Set<String> getResourceIds() {
//        return resourceIds;
//    }
//
//    public void setResourceIds(Set<String> resourceIds) {
//        this.resourceIds = resourceIds;
//    }


    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public boolean isSecretRequired() {
        return secretRequired;
    }

    public void setSecretRequired(boolean secretRequired) {
        this.secretRequired = secretRequired;
    }

    public boolean isScoped() {
        return scoped;
    }

    public void setScoped(boolean scoped) {
        this.scoped = scoped;
    }

//    public Set<String> getScopes() {
//        return scopes;
//    }
//
//    public void setScopes(Set<String> scopes) {
//        this.scopes = scopes;
//    }


    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }


//    public Collection<String> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Set<String> authorities) {
//        this.authorities = authorities;
//    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }



}
