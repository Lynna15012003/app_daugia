package com.example.doanapp.model;

import java.io.Serializable;

public class Order implements Serializable {
    int IdOrder;
    int IdUserOrder;
    int IdProOrder;
    int Quantity;
    String Date;
    String Color;
    String Size;
    String Name;
    String Phone;
    String Address;
    int Status;

    public Order(int idUserOrder, int idProOrder, int quantity, String date, String color, String size, String name, String phone, String address, int status) {
        IdUserOrder = idUserOrder;
        IdProOrder = idProOrder;
        Quantity = quantity;
        Date = date;
        Color = color;
        Size = size;
        Name = name;
        Phone = phone;
        Address = address;
        Status = status;
    }

    public Order(int idOrder, int idUserOrder, int idProOrder, int quantity, String date, String color, String size, String name, String phone, String address, int status) {
        IdOrder = idOrder;
        IdUserOrder = idUserOrder;
        IdProOrder = idProOrder;
        Quantity = quantity;
        Date = date;
        Color = color;
        Size = size;
        Name = name;
        Phone = phone;
        Address = address;
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public int getIdUserOrder() {
        return IdUserOrder;
    }

    public void setIdUserOrder(int idUserOrder) {
        IdUserOrder = idUserOrder;
    }

    public int getIdProOrder() {
        return IdProOrder;
    }

    public void setIdProOrder(int idProOrder) {
        IdProOrder = idProOrder;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
