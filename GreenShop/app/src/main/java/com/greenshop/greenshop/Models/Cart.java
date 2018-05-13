package com.greenshop.greenshop.Models;

/**
 * Created by IT on 5/7/2018.
 */

public class Cart {
    private int price, qty;
    private String name, img;

    public Cart(String img, int price, String name, int qty) {
        this.img = img;
        this.price = price;
        this.name = name;
        this.qty = qty;
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
