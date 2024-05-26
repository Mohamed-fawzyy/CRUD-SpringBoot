package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;

import java.util.UUID;

public class Person {
    private final UUID id;

    @Nonnull
    private final String name;

    public Person(@JsonProperty UUID id, @JsonProperty String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
