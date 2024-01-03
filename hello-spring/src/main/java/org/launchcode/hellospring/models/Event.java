package org.launchcode.hellospring.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Event extends AbstractEntity{
    @NotBlank(message = "Name is required!")
    @Size(min=3,max=50,message = "Name must have between 3 and 50 characters!")
    private String name;

    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;
    public Event(){
    }
    public Event(String name, EventCategory eventCategory, EventDetails eventDetails) {
        this.name = name;
        this.eventCategory = eventCategory;
        this.eventDetails = eventDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }
    @Override
    public String toString() {
        return name;
    }


}
