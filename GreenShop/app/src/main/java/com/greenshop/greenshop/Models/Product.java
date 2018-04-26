package com.greenshop.greenshop.Models;

import java.io.Serializable;

public class Product implements Serializable{
    private String id, name, description, descriptionBenefits;
    private int idCategory;
    private float price, oldPrice;
    private String images[];

    public Product(String id, String name, String description, String descriptionBenefits, int
            idCategory, float price, float oldPrice, String[] images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.descriptionBenefits = descriptionBenefits;
        this.idCategory = idCategory;
        this.price = price;
        this.oldPrice = oldPrice;
        this.images = images;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionBenefits() {
        return descriptionBenefits;
    }

    public void setDescriptionBenefits(String descriptionBenefits) {
        this.descriptionBenefits = descriptionBenefits;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
