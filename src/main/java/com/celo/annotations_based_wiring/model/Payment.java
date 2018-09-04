package com.celo.annotations_based_wiring.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private boolean immediate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImmediate() {
        return immediate;
    }

    public void setImmediate(boolean immediate) {
        this.immediate = immediate;
    }

    @Override
    public String toString() {
        return "Payment{" + "name='" + name + '\'' + ", immediate=" + immediate + '}';
    }
}
