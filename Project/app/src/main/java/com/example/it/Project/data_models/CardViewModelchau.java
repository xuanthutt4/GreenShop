package com.example.it.Project.data_models;

/**
 * Created by IT on 3/12/2018.
 */

public class CardViewModelchau {
    private String cardName;
    private String gia;
    private int image;

    public CardViewModelchau(String cardName, String gia, int image) {
        this.cardName = cardName;
        this.gia = gia;
        this.image = image;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
