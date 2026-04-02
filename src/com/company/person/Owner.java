package com.company.person;

public final class Owner {
    private final String name;
    private final String id;
    private static int counter = 1;

    public Owner(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Владелец должен иметь валидное поля имени!");
        }
        this.name = name;
        this.id = "OWNER-" + counter++;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", id владельца='" + id + '\'';
    }
}
