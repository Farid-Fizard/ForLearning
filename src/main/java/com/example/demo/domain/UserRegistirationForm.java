package com.example.demo.domain;

import com.example.demo.validator.PasswordMatches;
import com.example.demo.validator.UniqueEmail;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.example.demo.validator.ValidationConstants.*;

@Component
@PasswordMatches
public class UserRegistirationForm {

    @NotBlank(message = "{userRegistration.name.required}")
    @Size(min = NAME_LENGTH_MIN, max =NAME_LENGTH_MAX, message = "Olcu duzgun teyin olunmayib")
    private String name;

    @NotBlank
    @Size(min = 3,max = 20)
    private String surname;

    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    @NotBlank
    @Size(min = 10,max = 20)
    private String phone;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    private String passwordConfirmation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    @Override
    public String toString() {
        return "UserRegistirationForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                '}';
    }
}
