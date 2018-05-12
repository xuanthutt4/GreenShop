package com.greenshop.greenshop.Models;

/**
 * Created by IT on 5/7/2018.
 */

public class Cart {
    private int img, price;
    private String name;

    public Cart(int img, int price, String name, int qty) {
        this.img = img;
        this.price = price;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
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
