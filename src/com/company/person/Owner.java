package com.company.person;

public class Owner {
    private final String name;
    private final String id;

    public Owner(String name, String id) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Владелец должен иметь валидное поля имени!");
        } else {
            this.name = name;
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Владелец должен иметь валидное поля id!");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
