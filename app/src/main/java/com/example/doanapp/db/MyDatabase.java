package com.example.doanapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanapp.model.Order;
import com.example.doanapp.model.User;
import com.example.doanapp.model.Brand;
import com.example.doanapp.model.Cart;
import com.example.doanapp.model.Products;

import java.util.ArrayList;

public class MyDatabase {
    SQLiteDatabase database;
    DBHelper helper;

    public static ArrayList<Products> cartPro = new ArrayList<Products>();

    public MyDatabase(Context context) {
        helper = new DBHelper(context);
        database = helper.getWritableDatabase();
    }

    public ArrayList<Products> layTatCaDuLieu() {
        ArrayList<Products> arrPro = new ArrayList<Products>();

        String select = "Select * from " + DBHelper.TEN_BANG_PRODUCTS;

        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            int cate = cursor.getInt(3);
            int brand = cursor.getInt(4);
            int price = cursor.getInt(5);
            String image = cursor.getString(6);
            String size = cursor.getString(7);
            String color = cursor.getString(8);

            Products products = new Products(id, name, des, cate, brand, price, image, size, color);
            arrPro.add(products);
        }
        return arrPro;
    }

    public ArrayList<Brand> brands(){
        ArrayList<Brand> arrBrands = new ArrayList<Brand>();
        String select = "Select * from " + DBHelper.TEN_BANG_BRAND;

        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String image = cursor.getString(2);
            Brand brand = new Brand(id, name, image);
            arrBrands.add(brand);
        }

        return  arrBrands;
    }

    public ArrayList<String> layLoai(){
        ArrayList<String> tmp = new ArrayList<String>();
        String select = "Select "+ DBHelper.COT_NAME_CATEGORY + " from " + DBHelper.TEN_BANG_CATEGORY;
        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            tmp.add(id);
        }
        return tmp;
    }

    public ArrayList<String> layBrand(){
        ArrayList<String> tmp = new ArrayList<String>();
        String select = "Select "+ DBHelper.COT_NAME_BRAND + " from " + DBHelper.TEN_BANG_BRAND;
        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            tmp.add(id);
        }
        return tmp;
    }

    public int layIdBrand(String nameBrand){

        String select = "SELECT " + DBHelper.COT_ID_BRAND + " FROM " + DBHelper.TEN_BANG_BRAND + " WHERE " + DBHelper.COT_NAME_BRAND + " = '" + nameBrand + "'";
        Cursor cursor = database.rawQuery(select, null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public String layNameBrand(int IdBrand){

        String select = "SELECT " + DBHelper.COT_NAME_BRAND + " FROM " + DBHelper.TEN_BANG_BRAND + " WHERE " + DBHelper.COT_ID_BRAND + " = " + IdBrand;
        Cursor cursor = database.rawQuery(select, null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public int layIdCate(String nameCate){

        String select = "SELECT " + DBHelper.COT_ID_CATEGORY + " FROM " + DBHelper.TEN_BANG_CATEGORY + " WHERE " + DBHelper.COT_NAME_CATEGORY + " = '" + nameCate + "'";
        Cursor cursor = database.rawQuery(select, null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public String layNameCate(int IdCate){

        String select = "SELECT " + DBHelper.COT_NAME_CATEGORY + " FROM " + DBHelper.TEN_BANG_CATEGORY + " WHERE " + DBHelper.COT_ID_CATEGORY + " = " + IdCate;
        Cursor cursor = database.rawQuery(select, null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public ArrayList<Products> LocSanPham(String hang, String loai, String gia) {
        ArrayList<Products> arrPro = new ArrayList<Products>();

        if(hang.equals("Hãng")){
            hang = "";
        }
        if (loai.equals("Loại")){
            loai = "";
        }
        if(gia.equals("Giá")){
            gia = "";
        }else if(gia.equals("Thấp đến cao")){
            gia = "ORDER BY " + DBHelper.COT_PRICE + " ASC";
        }else {
            gia = "ORDER BY " + DBHelper.COT_PRICE + " DESC";
        }


        String select = "SELECT p.* FROM " + DBHelper.TEN_BANG_PRODUCTS + " p, " + DBHelper.TEN_BANG_BRAND + " b, " + DBHelper.TEN_BANG_CATEGORY + " c"
                + " WHERE p." + DBHelper.COT_BRAND_PRO + " = b." + DBHelper.COT_ID_BRAND + " AND p." + DBHelper.COT_CATEGORY + " = c." + DBHelper.COT_ID_CATEGORY
                + " AND b." + DBHelper.COT_NAME_BRAND + " like '%" + hang + "%' AND c." + DBHelper.COT_NAME_CATEGORY + " like '%" + loai + "%'"
                + gia;


        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            int cate = cursor.getInt(3);
            int brand = cursor.getInt(4);
            int price = cursor.getInt(5);
            String image = cursor.getString(6);
            String size = cursor.getString(7);
            String color = cursor.getString(8);

            Products products = new Products(id, name, des, cate, brand, price, image, size, color);
            arrPro.add(products);
        }
        return arrPro;
    }


    public ArrayList<Products> layDuLieuBrand(int idBrand) {
        ArrayList<Products> arrPro = new ArrayList<Products>();
        String select = "Select * from " + DBHelper.TEN_BANG_PRODUCTS + " Where "+ DBHelper.COT_BRAND_PRO + "=" + idBrand;

        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            int cate = cursor.getInt(3);
            int brand = cursor.getInt(4);
            int price = cursor.getInt(5);
            String image = cursor.getString(6);
            String size = cursor.getString(7);
            String color = cursor.getString(8);

            Products products = new Products(id, name, des, cate, brand, price, image, size, color);
            arrPro.add(products);
        }
        return arrPro;
    }

    public ArrayList<Products> layDuLieuCategory(int idCate) {
        ArrayList<Products> arrPro = new ArrayList<Products>();

        String select = "Select * from " + DBHelper.TEN_BANG_PRODUCTS + " Where "+ DBHelper.COT_CATEGORY + "=" + idCate;

        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            int cate = cursor.getInt(3);
            int brand = cursor.getInt(4);
            int price = cursor.getInt(5);
            String image = cursor.getString(6);
            String size = cursor.getString(7);
            String color = cursor.getString(8);

            Products products = new Products(id, name, des, cate, brand, price, image, size, color);
            arrPro.add(products);
        }
        return arrPro;
    }


    public User Login(String email, String pass){
        String sql = "SELECT * FROM " + DBHelper.TEN_BANG_USER + " WHERE " + DBHelper.COT_EMAIL_USER + " = '" + email + "' " + " AND " + DBHelper.COT_PASS_USER + " = '" + pass + "' ";
        Cursor cursor = database.rawQuery(sql, null);
        User tmp = null;
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            int id = cursor.getInt(0);
            String Name = cursor.getString(1);
            String Email = cursor.getString(2);
            String Pass = cursor.getString(3);
            String Phone = cursor.getString(4);
            String Address = cursor.getString(5);
            int role = cursor.getInt(6);
            tmp = new User(id, Name, Email, Pass, Phone, Address, role);
        }
        return tmp;
    }

    public boolean CheckRegister(String email){
        String sql = "SELECT * FROM " + DBHelper.TEN_BANG_USER + " WHERE " + DBHelper.COT_EMAIL_USER + " = '" + email + "' ";
        Cursor cursor = database.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    public User selectUser(int idUser){
        String sql = "SELECT * FROM " + DBHelper.TEN_BANG_USER + " WHERE " + DBHelper.COT_ID_User + " = " + idUser ;
        Cursor cursor = database.rawQuery(sql, null);
        User tmp = null;
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            int id = cursor.getInt(0);
            String Name = cursor.getString(1);
            String Email = cursor.getString(2);
            String Pass = cursor.getString(3);
            String Phone = cursor.getString(4);
            String Address = cursor.getString(5);
            int role = cursor.getInt(6);
            tmp = new User(id, Name, Email, Pass, Phone, Address, role);
        }
        return tmp;
    }

    public long AddUser(User user)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_NAME_USER, user.getNameUser());
        values.put(DBHelper.COT_EMAIL_USER, user.getEmail());
        values.put(DBHelper.COT_PASS_USER, user.getPassword());
        values.put(DBHelper.COT_PHONE_USER, user.getPhone());
        values.put(DBHelper.COT_ADDRESS_USER, user.getAddress());
        values.put(DBHelper.COT_ROLE_USER, user.getRole());

        return database.insert(DBHelper.TEN_BANG_USER, "", values);
    }

    public long UpdateUser(int IdUser, String name, String phone, String address){
        User user = selectUser(IdUser);
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_NAME_USER, name);
        values.put(DBHelper.COT_EMAIL_USER, user.getEmail());
        values.put(DBHelper.COT_PASS_USER, user.getPassword());
        values.put(DBHelper.COT_PHONE_USER, phone);
        values.put(DBHelper.COT_ADDRESS_USER, address);
        values.put(DBHelper.COT_ROLE_USER, user.getRole());

        return database.update(DBHelper.TEN_BANG_USER, values,
                DBHelper.COT_ID_USER + " = " + IdUser, null);
    }


    public ArrayList<Products> search(String query){
        ArrayList<Products> tmp = new ArrayList<>();

        String sql = "SELECT * FROM " + DBHelper.TEN_BANG_PRODUCTS + " WHERE " + DBHelper.COT_NAME_PRO + " LIKE '%" + query + "%' ";
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String des = cursor.getString(2);
            int cate = cursor.getInt(3);
            int brand = cursor.getInt(4);
            int price = cursor.getInt(5);
            String image = cursor.getString(6);
            String size = cursor.getString(7);
            String color = cursor.getString(8);

            Products products = new Products(id, name, des, cate, brand, price, image, size, color);
            tmp.add(products);
        }

        return tmp;
    }


    public long AddCart(Cart cart)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_ID_Pro, cart.getIdProCart());
        values.put(DBHelper.COT_ID_User, cart.getIdUserCart());
        values.put(DBHelper.COT_QUANTITY, cart.getQuantity());
        values.put(DBHelper.COT_COLOR_CART, cart.getColor());
        values.put(DBHelper.COT_SIZE_CART, cart.getSize());

        return database.insert(DBHelper.TEN_BANG_CART, "", values);
    }

    public long DeleteCart(Cart cart) {

        return database.delete(DBHelper.TEN_BANG_CART, DBHelper.COT_ID_CART + " = " + cart.getIdOrderCard(), null);
    }

    public long DeleteCart(int idCart) {

        return database.delete(DBHelper.TEN_BANG_CART, DBHelper.COT_ID_CART + " = " + idCart, null);
    }


    public ArrayList<Cart> selectCart(int idUser){
        ArrayList<Cart> tmp = new ArrayList<Cart>();
        String sql = "";
        if(idUser == 0) {
            sql = "Select * from " + DBHelper.TEN_BANG_CART + " WHERE " + DBHelper.COT_ID_User_Order + "=" + idUser + " ORDER BY " + DBHelper.COT_ID_CART + " DESC";
        }else {
            sql = "Select * from " + DBHelper.TEN_BANG_CART + " WHERE " + DBHelper.COT_ID_User_Order + "=" + idUser + " OR " + DBHelper.COT_ID_User_Order + "= 0" + " ORDER BY " + DBHelper.COT_ID_CART + " DESC";
        }

        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            int id1 = cursor.getInt(1);
            int id2 = cursor.getInt(2);
            int id3 = cursor.getInt(3);
            String id4 = cursor.getString(4);
            String id5 = cursor.getString(5);
            Cart cart = new Cart(id, id1, id2, id3, id4, id5);
            tmp.add(cart);
        }
        return tmp;
    }

    public void CheckAndAddCart(Cart cart){
        String sql = "Select * from " + DBHelper.TEN_BANG_CART + " where " + DBHelper.COT_ID_Pro + "=" + cart.getIdProCart();
        Cursor cursor = database.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                int idOrder = cursor.getInt(0);
                //int idProCart = cursor.getInt(1);
                int idUserCart = cursor.getInt(2);
                int Quantity = cursor.getInt(3);
                String color = cursor.getString(4);
                String size = cursor.getString(5);

                if(idUserCart == cart.getIdUserCart() && color.equals(cart.getColor()) && size.equals(cart.getSize())){
                    int newQuantity = cart.getQuantity() + Quantity;
                    DeleteCart(idOrder);
                    cart.setQuantity(newQuantity);
                    AddCart(cart);
                    return;
                }
            }
            AddCart(cart);
            return;
        }
        AddCart(cart);

    }

    public Products getInfoPro(int idPro){
        String info = "Select * from " + DBHelper.TEN_BANG_PRODUCTS + " where " + DBHelper.COT_ID_PRO + "=" + idPro;

        Cursor cursor = database.rawQuery(info, null);
        cursor.moveToFirst();
        int id = cursor.getInt(0);
        String name = cursor.getString(1);
        String des = cursor.getString(2);
        int cate = cursor.getInt(3);
        int brand = cursor.getInt(4);
        int price = cursor.getInt(5);
        String image = cursor.getString(6);
        String size = cursor.getString(7);
        String color = cursor.getString(8);

        Products products = new Products(id, name, des, cate, brand, price, image, size, color);

        return products;
    }

    public long AddOrder(Order order)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_ID_User_Order, order.getIdUserOrder());
        values.put(DBHelper.COT_ID_Pro_Order, order.getIdProOrder());
        values.put(DBHelper.COT_QUANTITY_Order, order.getQuantity());
        values.put(DBHelper.COT_DATE_ORDER, order.getDate());
        values.put(DBHelper.COT_COLOR_Order, order.getColor());
        values.put(DBHelper.COT_SIZE_Order, order.getSize());
        values.put(DBHelper.COT_NAME_Order, order.getName());
        values.put(DBHelper.COT_PHONE_Order, order.getPhone());
        values.put(DBHelper.COT_ADDRESS_Order, order.getAddress());
        values.put(DBHelper.COT_STATUS_Order, order.getStatus());


        return database.insert(DBHelper.TEN_BANG_ORDER, "", values);
    }

    public long EditOrder(Order order, int status)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_ID_User_Order, order.getIdUserOrder());
        values.put(DBHelper.COT_ID_Pro_Order, order.getIdProOrder());
        values.put(DBHelper.COT_QUANTITY_Order, order.getQuantity());
        values.put(DBHelper.COT_DATE_ORDER, order.getDate());
        values.put(DBHelper.COT_COLOR_Order, order.getColor());
        values.put(DBHelper.COT_SIZE_Order, order.getSize());
        values.put(DBHelper.COT_NAME_Order, order.getName());
        values.put(DBHelper.COT_PHONE_Order, order.getPhone());
        values.put(DBHelper.COT_ADDRESS_Order, order.getAddress());
        values.put(DBHelper.COT_STATUS_Order, status);


        return database.update(DBHelper.TEN_BANG_ORDER, values,
                DBHelper.COT_ID_ORDER + " = " + order.getIdOrder(), null);
    }

    public ArrayList<Order> selectOrderForAdmin(){
        ArrayList<Order> orders = new ArrayList<Order>();
        String select = "Select * from " + DBHelper.TEN_BANG_ORDER + " WHERE " + DBHelper.COT_STATUS_Order + " = 0" +" GROUP BY " + DBHelper.COT_ID_User_Order;
        Cursor cursor = database.rawQuery(select, null);

        while (cursor.moveToNext()){
            int IdOrder = cursor.getInt(0);
            int IdUserOrder = cursor.getInt(1);
            int IdProOrder = cursor.getInt(2);
            int Quantity = cursor.getInt(3);
            String Date = cursor.getString(4);
            String Color = cursor.getString(5);
            String Size = cursor.getString(6);
            String Name = cursor.getString(7);
            String Phone = cursor.getString(8);
            String Address = cursor.getString(9);
            int Status = cursor.getInt(10);

            Order o = new Order(IdOrder, IdUserOrder, IdProOrder, Quantity, Date, Color, Size, Name, Phone, Address, Status);
            orders.add(o);
        }

        return orders;
    }

    public ArrayList<Order> selectOrder(int idUser, int status){
        ArrayList<Order> orders = new ArrayList<Order>();
        String select = "Select * from " + DBHelper.TEN_BANG_ORDER + " WHERE " + DBHelper.COT_ID_User_Order + " = " + idUser + " AND " + DBHelper.COT_STATUS_Order + " = " + status;
        Cursor cursor = database.rawQuery(select, null);

        while (cursor.moveToNext()){
            int IdOrder = cursor.getInt(0);
            int IdUserOrder = cursor.getInt(1);
            int IdProOrder = cursor.getInt(2);
            int Quantity = cursor.getInt(3);
            String Date = cursor.getString(4);
            String Color = cursor.getString(5);
            String Size = cursor.getString(6);
            String Name = cursor.getString(7);
            String Phone = cursor.getString(8);
            String Address = cursor.getString(9);
            int Status = cursor.getInt(10);

            Order o = new Order(IdOrder, IdUserOrder, IdProOrder, Quantity, Date, Color, Size, Name, Phone, Address, Status);
            orders.add(o);
        }

        return orders;
    }

    public long AddPro(Products products) {

        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_NAME_PRO, products.getName());
        values.put(DBHelper.COT_DESCRIPTION_PRO, products.getDescription());
        values.put(DBHelper.COT_CATEGORY, products.getCategory());
        values.put(DBHelper.COT_BRAND_PRO, products.getBrand());
        values.put(DBHelper.COT_PRICE, products.getPrice());
        values.put(DBHelper.COT_IMAGE_PRO, products.getImagePro());
        values.put(DBHelper.COT_SIZE_PRO, products.getSize());
        values.put(DBHelper.COT_COLOR_PRO, products.getColor());

        return database.insert(DBHelper.TEN_BANG_PRODUCTS, null, values);
    }

    public long DeletePro(Products products) {

        return database.delete(DBHelper.TEN_BANG_PRODUCTS, DBHelper.COT_ID_PRO + " = " + products.getId() , null);
    }

    public long EditPro(Products products) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_NAME_PRO, products.getName());
        values.put(DBHelper.COT_CATEGORY, products.getCategory());
        values.put(DBHelper.COT_BRAND_PRO, products.getBrand());
        values.put(DBHelper.COT_DESCRIPTION_PRO, products.getDescription());
        values.put(DBHelper.COT_PRICE, products.getPrice());
        values.put(DBHelper.COT_IMAGE_PRO, products.getImagePro());
        values.put(DBHelper.COT_SIZE_PRO, products.getSize());
        values.put(DBHelper.COT_COLOR_PRO, products.getColor());

        return database.update(DBHelper.TEN_BANG_PRODUCTS, values,
                DBHelper.COT_ID_PRO + " = " + products.getId(), null);
    }


    public String selectNameBrand(){
        String tmp = "";
        String sql = "SELECT " + DBHelper.COT_NAME_BRAND + " FROM " + DBHelper.TEN_BANG_BRAND;
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            String b = cursor.getString(0);
            tmp += b + ",";
        }
        return tmp;
    }

    public String selectNameCategory(){
        String tmp = "";
        String sql = "SELECT " + DBHelper.COT_NAME_CATEGORY + " FROM " + DBHelper.TEN_BANG_CATEGORY;
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            String b = cursor.getString(0);
            tmp += b + ",";
        }
        return tmp;
    }

    public long AddBrand(Brand brand){
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_NAME_BRAND, brand.getNameBrand());
        values.put(DBHelper.COT_IMAGE_BRAND, brand.getImageBrand());

        return database.insert(DBHelper.TEN_BANG_BRAND, null, values);
    }

    public long EditBrand(Brand brand){
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_NAME_BRAND, brand.getNameBrand());
        values.put(DBHelper.COT_IMAGE_BRAND, brand.getImageBrand());

        return database.update(DBHelper.TEN_BANG_BRAND, values, DBHelper.COT_ID_BRAND + " = " + brand.getId(), null);
    }

    public long DeleteBrand(Brand brand){
        return database.delete(DBHelper.TEN_BANG_BRAND, DBHelper.COT_ID_BRAND + " = " + brand.getId() , null);
    }
}
