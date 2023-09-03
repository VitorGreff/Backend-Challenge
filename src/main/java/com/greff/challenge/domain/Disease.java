package com.greff.challenge.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;


@Document("disease")
public class Disease implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer severity;

    public Disease() {
    }

    public Disease(String id, String name, Integer severity) {
        this.id = id;
        this.name = name;
        this.severity = severity;
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

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return Objects.equals(id, disease.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
