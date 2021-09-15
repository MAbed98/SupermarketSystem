package com.example.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id ;

    @Column(name = "customer_name")
    private String customerName ;

    @Column(name = "customer_phone")
    private String customerPhone ;

    @Column(name = "date")
    private String date;

    @Column(name = "products")
    private String products ;



    public Order(String customerName, String customerPhone, String date, String products) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.date = date;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", date=" + date +
                ", products=" + products +
                '}';
    }
}
