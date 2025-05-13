package com.program.app.adapter.service;

import org.springframework.stereotype.Service;

import com.program.app.models.LegacyUser;


@Service
public class LegacyUserService {
    public LegacyUser findUser(String username) {
        // Implementación simulada
        return new LegacyUser(username, username + "@example.com");
    }
}
