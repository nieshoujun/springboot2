package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvPropertiesInfo {

    @Value("${env.clientId}")
    private String clientId;

    @Value("${env.clientSecret}")
    private String clientSecret;

    @Value("${env.u2AuthorizeUrl}")
    private String u2AuthorizeUrl;

    @Value("${env.callbackUrl}")
    private String callbackUrl;

    @Value("${env.u2AccessTokenUrl}")
    private String u2AccessTokenUrl;

    public String getU2AccessTokenUrl() {
        return u2AccessTokenUrl;
    }

    public void setU2AccessTokenUrl(String u2AccessTokenUrl) {
        this.u2AccessTokenUrl = u2AccessTokenUrl;
    }

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

    public String getU2AuthorizeUrl() {
        return u2AuthorizeUrl;
    }

    public void setU2AuthorizeUrl(String u2AuthorizeUrl) {
        this.u2AuthorizeUrl = u2AuthorizeUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
