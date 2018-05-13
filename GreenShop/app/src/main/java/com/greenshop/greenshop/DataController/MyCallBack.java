package com.greenshop.greenshop.DataController;

import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.Models.Product;

import java.util.ArrayList;

public interface MyCallBack {
    void onCallback(ArrayList<Product> value);
    void onCallbackCart (ArrayList<Cart> value);
}
