package com.example.doanapp.model;

import java.io.Serializable;

public class Cart implements Serializable {
    int IdOrderCard;
    int IdUserCart;
    int IdProCart;
    int Quantity;
    String Color;
    String Size;

    public Cart(int idProCart, int quantity, String color, String size) {

        IdProCart = idProCart;
        Quantity = quantity;
        Color = color;
        Size = size;
    }

    public Cart(int idProCart, int idUserCart, int quantity, String color, String size) {

        IdProCart = idProCart;
        IdUserCart = idUserCart;
        Quantity = quantity;
        Color = color;
        Size = size;
    }

    public Cart(int idOrderCard, int idProCart, int idUserCart, int quantity, String color, String size) {
        IdOrderCard = idOrderCard;
        IdUserCart = idUserCart;
        IdProCart = idProCart;
        Quantity = quantity;
        Color = color;
        Size = size;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public int getIdOrderCard() {
        return IdOrderCard;
    }

    public void setIdOrderCard(int idOrderCard) {
        IdOrderCard = idOrderCard;
    }

    public int getIdUserCart() {
        return IdUserCart;
    }

    public void setIdUserCart(int idUserCart) {
        IdUserCart = idUserCart;
    }

    public int getIdProCart() {
        return IdProCart;
    }

    public void setIdProCart(int idProCart) {
        IdProCart = idProCart;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
