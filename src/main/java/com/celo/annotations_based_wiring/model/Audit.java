package com.celo.annotations_based_wiring.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Entity
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String className;

    @Column
    private String operation;

    @Column
    private LocalDate date;

    public Audit(String className, String operation) {
        this.className = className;
        this.operation = operation;
        this.date = LocalDate.now();
    }

    public Audit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
