package com.company.person;

import java.util.Objects;

public final class Owner {
    private final String name;
    private final String id;
    private static int counter = 1;
    private final String clientCode;

    public Owner(String clientCode, String name) {
        if (clientCode == null || clientCode.isBlank()) {
            throw new IllegalArgumentException("Внутренний код клиента не должен быть null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Владелец должен иметь валидное поля имени!");
        }
        this.clientCode = clientCode;
        this.name = name;
        this.id = "OWNER-" + counter++;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getClientCode() {
        return clientCode;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", id владельца='" + id + '\'';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Owner owner)) return false;
        return Objects.equals(clientCode, owner.clientCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clientCode);
    }
}
