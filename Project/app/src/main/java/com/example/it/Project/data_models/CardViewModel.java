package com.example.it.Project.data_models;

/**
 * Created by IT on 3/12/2018.
 */

public class CardViewModel {
    private String cardName;
    private int image;

    public CardViewModel(String cardName, int image) {
        this.cardName = cardName;
        this.image = image;
    }

    public String getCardName() {
        return cardName;
    }

    public int getImage() {
        return image;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
