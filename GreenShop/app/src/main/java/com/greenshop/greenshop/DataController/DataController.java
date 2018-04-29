package com.greenshop.greenshop.DataController;

import com.greenshop.greenshop.Models.Category;
import com.greenshop.greenshop.Models.Product;

import java.util.ArrayList;

public class DataController {

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("1", "Cây 1", "Cây ...", "Cây mang lại lợi ích", 1, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 2", "Cây ...", "Cây mang lại lợi ích", 1, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 3", "Cây ...", "Cây mang lại lợi ích", 1, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 4", "Cây ...", "Cây mang lại lợi ích", 1, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 5", "Cây ...", "Cây mang lại lợi ích", 2, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 6", "Cây ...", "Cây mang lại lợi ích", 2, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 7", "Cây ...", "Cây mang lại lợi ích", 2, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 8", "Cây ...", "Cây mang lại lợi ích", 2, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 9", "Cây ...", "Cây mang lại lợi ích", 3, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 10", "Cây ...", "Cây mang lại lợi ích", 3, 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 11", "Cây ...", "Cây mang lại lợi ích", 3, 110000, 210000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 12", "Cây ...", "Cây mang lại lợi ích", 3, 120000, 130000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 13", "Cây ...", "Cây mang lại lợi ích", 3, 130000, 140000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 14", "Cây ...", "Cây mang lại lợi ích", 3, 140000, 160000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 15", "Cây ...", "Cây mang lại lợi ích", 3, 150000, 180000, new String[] {"cay_canh"}));
        products.add(new Product("1", "Cây 16", "Cây ...", "Cây mang lại lợi ích", 3, 160000, 200000, new String[] {"cay_canh"}));

        return products;
    }

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Cây cảnh"));
        categories.add(new Category(2, "Cây phong thủy"));
        categories.add(new Category(3, "Cây trong nhà"));

        return categories;
    }

    public ArrayList<Product> getProductsByCategory(String idCategory) {
        ArrayList<Product> products = new ArrayList<>();
        /*
         * - Add product into array
         */

        return products;
    }
}
