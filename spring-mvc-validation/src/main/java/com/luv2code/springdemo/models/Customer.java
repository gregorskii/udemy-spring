package com.luv2code.springdemo.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Component
public class Customer {

    @NotNull(message="{NotNull.customer.firstName}")
    @Size(min=1, message="{Size.customer.firstName}")
    private String firstName;

    @NotNull(message="{NotNull.customer.lastName}")
    @Size(min=1, message="{Size.customer.lastName}")
    private String lastName;

    @NotNull(message="{NotNull.customer.description}")
    @Size(min=1, message="{Size.customer.description}")
    private String description;

    // TODO: typeMistmatch does not work.
    @NotNull
    @Min(value=1, message="{Min.customer.age}")
    @Max(value=110, message="{Max.customer.age}")
    private Integer age;

    @NotNull(message="{NotNull.customer.zipCode}")
    @Pattern(regexp="^[0-9]{5}(-[0-9]{4})?", message="{Pattern.customer.zipCode}")
    private String zipCode;

    public Customer() { }

    public Customer(
        String firstName,
        String lastName,
        String description,
        Integer age,
        String zipCode
    ) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDescription(description);
        this.setAge(age);
        this.setZipCode(zipCode);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
