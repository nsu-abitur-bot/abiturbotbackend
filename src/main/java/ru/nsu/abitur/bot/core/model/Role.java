package ru.nsu.abitur.bot.core.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_VIEWER;

    @Override
    public String getAuthority() {
        return name();
    }
}
