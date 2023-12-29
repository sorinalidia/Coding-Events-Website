package org.launchcode.hellospring.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;

    @NotBlank
    @Size(min=3,max=50,message = "Name must have between 3 and 50 characters!")
    private String name;

    @Size(max=500,message = "Description too long!")
    private String description;

    @NotBlank
    @Email(message = "Invalid email. Try again!")
    private String contactEmail;

    public Event(String name, String description, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
