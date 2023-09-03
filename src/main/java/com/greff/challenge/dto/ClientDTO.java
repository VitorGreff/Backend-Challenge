package com.greff.challenge.dto;

import com.greff.challenge.domain.enums.Gender;

import java.io.Serializable;
import java.util.Date;

public class ClientDTO implements Serializable {
    private String name;
    private String gender;
    private Date birthDate;

    public ClientDTO() {
    }

    public ClientDTO(String name, Date birthDate,String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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
