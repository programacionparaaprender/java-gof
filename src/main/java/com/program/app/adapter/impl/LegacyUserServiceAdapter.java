package com.program.app.adapter.impl;

import org.springframework.stereotype.Service;

import com.program.app.adapter.ModernUserService;
import com.program.app.adapter.service.LegacyUserService;
import com.program.app.models.LegacyUser;
import com.program.app.models.UserDto;

@Service
public class LegacyUserServiceAdapter implements ModernUserService {
    private final LegacyUserService legacyUserService;

    public LegacyUserServiceAdapter(LegacyUserService legacyUserService) {
        this.legacyUserService = legacyUserService;
    }

    @Override
    public UserDto getUser(String username) {
        LegacyUser legacyUser = legacyUserService.findUser(username);
        return convertToUserDto(legacyUser);
    }

    private UserDto convertToUserDto(LegacyUser legacyUser) {
        // Lógica de conversión
        return new UserDto(legacyUser.getUsername(), legacyUser.getEmail());
    }
}
