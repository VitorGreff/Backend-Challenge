package com.greff.challenge.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private String name;
    private String birthDate;
    private String gender;

    public ClientDTO() {
    }

    public ClientDTO(String name, String birthDate ,String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
