package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id ;
    @Column(name = "name")
    private String name ;
    @Column(name = "price")
    private float price ;
    @Column(name = "production_date")
    private Date production_date ;
    @Column(name = "expiry_date")
    private Date expiry_date ;
    @Column(name = "number_of_items")
    private int number_of_items ;
    @Column(name = "category")
    private String category ;
    @Column(name = "made_in")
    private String made_in ;
    @Column(name = "width")
    private float width ;
    @Column(name = "height")
    private float height ;
    @Column(name = "length")
    private float length ;
    @Column(name = "active")
    private boolean active ;

    public Product(){

    }
    public Product(int id, String name, float price, Date production_date, Date expiry_date,int number_of_items,
                   String category, String made_in, float width, float height, float length , boolean active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.production_date = production_date;
        this.expiry_date = expiry_date;
        this.number_of_items = number_of_items;
        this.category = category;
        this.made_in = made_in;
        this.width = width;
        this.height = height;
        this.length = length;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getNumber_of_items() {
        return number_of_items;
    }

    public void setNumber_of_items(int number_of_items) {
        this.number_of_items = number_of_items;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMade_in() {
        return made_in;
    }

    public void setMade_in(String made_in) {
        this.made_in = made_in;
    }

    public float getwidth() {
        return width;
    }

    public void setwidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", production_date=" + production_date +
                ", expiry_date=" + expiry_date +
                ", number_of_items=" + number_of_items +
                ", category='" + category + '\'' +
                ", made_in='" + made_in + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", active=" + active +
                '}';
    }
}
