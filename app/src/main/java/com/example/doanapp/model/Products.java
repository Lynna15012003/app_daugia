package com.example.doanapp.model;

import java.io.Serializable;

public class Products implements Serializable {
    private int Id;
    private String Name;
    private String Description;
    private int Category;
    private int Brand;
    private int Price;
//    private byte[] ImagePro;
    private String ImagePro;
    private String Size;
    private String Color;

    public Products(int id, String name, String description, int category, int brand, int price, String imagePro, String size, String color) {
        Id = id;
        Name = name;
        Description = description;
        Category = category;
        Brand = brand;
        Price = price;
        ImagePro = imagePro;
        Size = size;
        Color = color;
    }



    public Products(String name, String description, int category, int brand, int price, String imagePro, String size, String color) {
        Name = name;
        Description = description;
        Category = category;
        Brand = brand;
        Price = price;
        ImagePro = imagePro;
        Size = size;
        Color = color;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public int getBrand() {
        return Brand;
    }

    public void setBrand(int brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

//    public byte[] getImagePro() {return ImagePro;}

//    public void setImagePro(byte[] imagePro) {
//        ImagePro = imagePro;
//    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }


    public String getImagePro() {
        return ImagePro;
    }
    public void setImagePro(String imagePro) {
        ImagePro = imagePro;
    }
}
