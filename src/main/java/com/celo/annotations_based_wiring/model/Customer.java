package com.celo.annotations_based_wiring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product; //injected via a setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    @Autowired() //can be used with any method, even constructors, not just setters
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Customer{" + "name='" + name + '\'' + ", product=" + product + ", payment=" + payment + '}';
    }
}
