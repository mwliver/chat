package pl.edu.us.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import pl.edu.us.config.CustomUserDetailsService;
import pl.edu.us.persistance.client.dao.User;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class BaseController {
    protected User getUser(OAuth2Authentication auth) {
        CustomUserDetailsService.UserRepositoryUserDetails userDetails = (CustomUserDetailsService.UserRepositoryUserDetails) auth.getPrincipal();

        return userDetails.user;
    }
}