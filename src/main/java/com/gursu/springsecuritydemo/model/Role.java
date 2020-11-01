package com.gursu.springsecuritydemo.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.DEVELOPER_WRITE, Permission.DEVELOPER_READ)),
    USER(Set.of(Permission.DEVELOPER_READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return this.permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
