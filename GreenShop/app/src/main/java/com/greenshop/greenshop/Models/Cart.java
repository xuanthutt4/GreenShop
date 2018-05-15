package com.greenshop.greenshop.Models;

import java.io.Serializable;

/**
 * Created by IT on 5/7/2018.
 */

public class Cart implements Serializable{
    private int price, qty;
    private String name, img, id;

    public Cart(String id, String img, int price, String name, int qty) {
        this.img = img;
        this.price = price;
        this.name = name;
        this.qty = qty;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
