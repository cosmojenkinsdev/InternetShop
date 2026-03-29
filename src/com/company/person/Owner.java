package com.company.person;

public final class Owner {
    private final String name;
    private final String id;

    public Owner(String name, String id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Владелец должен иметь валидное поля имени!");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Владелец должен иметь валидное поля id!");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
