package com.example.supermarket;

public class ShopItem {
    private String name;
    private int pictureId;
    private double price;

    public ShopItem(String name, int pictureId, double price) {
        this.name=name;
        this.pictureId=pictureId;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPictureId() {
        return pictureId;
    }

    public double getPrice() {
        return price;
    }
}
