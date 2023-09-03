package com.greff.challenge.domain;

import com.greff.challenge.domain.enums.Gender;
import com.greff.challenge.domain.enums.Severity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document("client")
public class Client implements Serializable, Comparable<Client>{

    @Id
    private String id;
    private String name;
    private Date birthDate;
    private Gender gender;
    private Date creationDate;
    private Date updateDate;
    @DBRef(lazy = true)
    private List<Disease> diseases = new ArrayList<>();

    public Client(){}

    public Client(String id, String name, Date birthDate, String gender, Date creationDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = Gender.valueOf(gender);
        this.creationDate = creationDate;
        updateDate = creationDate;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Client other){
        return Double.compare(this.calculateScore(), other.calculateScore());
    }
    
    public Double calculateScore(){
        Integer sd = 0;
        Double score;

        for (Disease x: diseases
             ) {
            if(x.getSeverity() == Severity.TYPE1)
                sd += 1;

            else
                sd+=2;
        }
        score = (1/(1+Math.exp(-2.8 + sd))) * 100;
        return score;
    }
}
