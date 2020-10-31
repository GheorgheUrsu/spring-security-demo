package com.gursu.springsecuritydemo.model;

public enum Permission {
    DEVELOPER_READ("DEVELOPER:READ"),
    DEVELOPER_WRITE("DEVELOPER:WRITE");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
