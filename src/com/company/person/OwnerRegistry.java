package com.company.person;

import java.util.HashMap;
import java.util.Map;

public final class OwnerRegistry {
    private static final Map<String, Owner> ownersByClientCode = new HashMap<>();

    private OwnerRegistry() {
    }

    public static Owner getOrCreateOwner(String clientCode, String name) {
        if (clientCode == null || clientCode.isBlank()) {
            throw new IllegalArgumentException("Client code не должен быть пустым");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя владельца не должно быть пустым");
        }

        Owner existingOwner = ownersByClientCode.get(clientCode);
        if (existingOwner != null) {
            return existingOwner;
        }

        Owner newOwner = new Owner(clientCode, name);
        ownersByClientCode.put(clientCode, newOwner);
        return newOwner;
    }

    public static Map<String, Owner> getOwners() {
        return Map.copyOf(ownersByClientCode);
    }
}