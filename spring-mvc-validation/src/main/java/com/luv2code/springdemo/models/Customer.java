package com.luv2code.springdemo.models;

import com.luv2code.springdemo.validation.BranchCode;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Component
public class Customer {

    @NotNull
    @Size(min=2, message="{Size.customer.firstName}")
    private String firstName;

    @NotNull
    @Size(min=2, message="{Size.customer.lastName}")
    private String lastName;

    @NotNull
    @Size(min=2, message="{Size.customer.description}")
    private String description;

    @NotNull
    @Min(value=1, message="{Min.customer.age}")
    @Max(value=110, message="{Max.customer.age}")
    private Integer age;

    @NotNull
    @Pattern(regexp="^[0-9]{5}(-[0-9]{4})?")
    private String zipCode;

    @NotNull
    @Size(min=6, message="{Size.customer.branch}")
    @BranchCode(value="US1", message="{BranchCode.customer.branch}")
    private String branch;

    public Customer() { }

    public Customer(
        String firstName,
        String lastName,
        String description,
        Integer age,
        String zipCode,
        String branch
    ) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDescription(description);
        this.setAge(age);
        this.setZipCode(zipCode);
        this.setBranch(branch);
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
