package com.example.it.Project.data_models;

/**
 * Created by IT on 3/12/2018.
 */

public class CardViewModelchau {
    private String cardName;
    private int image, type, gia;

    public CardViewModelchau() {
    }

    public CardViewModelchau(String cardName, int gia, int image, int type) {
        this.cardName = cardName;
        this.gia = gia;
        this.image = image;
        this.type = type;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
