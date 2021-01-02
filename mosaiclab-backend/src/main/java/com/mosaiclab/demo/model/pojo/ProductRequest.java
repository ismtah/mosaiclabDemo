package com.mosaiclab.demo.model.pojo;

import com.mosaiclab.demo.model.entities.Product;

public class ProductRequest {
    private String name;
    private double price;
    private String marque;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product toProduct() {
        Product p =new Product();
        p.setName(name);
        p.setPrice(price);
        p.setMarque(marque);
        p.setType(type);
        return p;
    }
}
