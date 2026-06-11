package com.orangehrm.models;

public final class LoginCredentials {

    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin123";

    private LoginCredentials() {
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
