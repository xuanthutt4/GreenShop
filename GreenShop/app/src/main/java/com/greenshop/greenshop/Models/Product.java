package com.greenshop.greenshop.Models;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Product implements Serializable{
    private String id, name, description, descriptionBenefits, idCategory;
    private float price, oldPrice;
    private String images[];
    private int sale;
    private DecimalFormat format = new DecimalFormat("#,###,###");

    public Product(String id, String name, String description, String descriptionBenefits, String
            idCategory, int sale, float oldPrice, String[] images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.descriptionBenefits = descriptionBenefits;
        this.idCategory = idCategory;
        this.oldPrice = oldPrice;
        this.sale = sale;
        this.price = this.oldPrice - (this.oldPrice * this.sale / 100);
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

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public float getPrice() {
        return price;
    }

    public String getStringPrice() {
        return format.format(price)  + " đ";
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public String getStringOldPrice() {
        return format.format(oldPrice) + " đ";
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
        return name;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
