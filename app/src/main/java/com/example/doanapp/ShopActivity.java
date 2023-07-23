package com.example.doanapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.doanapp.adapter.ProductAdapter;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Products;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements ProductAdapter.Listener{

    RecyclerView rcvAllPro;
    ArrayList<Products> allPro;
    ProductAdapter proAdapter;
    ImageView imgBack;
    Button btnHang, btnLoai, btnGia;
    String flag = "";

    MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        rcvAllPro = (RecyclerView) findViewById(R.id.rcvAllPro);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        btnHang = (Button) findViewById(R.id.btnHang);
        btnLoai = (Button) findViewById(R.id.btnLoai);
        btnGia = (Button) findViewById(R.id.btnGia);
        database = new MyDatabase(ShopActivity.this);

        Intent intent = getIntent();
        allPro = (ArrayList<Products>) intent.getSerializableExtra("pro");
        proAdapter = new ProductAdapter(ShopActivity.this, allPro, ShopActivity.this);
        rcvAllPro.setAdapter(proAdapter);
        rcvAllPro.setLayoutManager(new GridLayoutManager(this, 2));


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ArrayList<String> sCate = database.layLoai();
        String[] cate = sCate.toArray(new String[sCate.size()]);
        btnLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(ShopActivity.this);
                dialogColor.setItems(cate, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnLoai.setText(cate[c]);

                        allPro.clear();
                        allPro.addAll(database.LocSanPham(btnHang.getText().toString(), btnLoai.getText().toString(), btnGia.getText().toString()));
                        proAdapter.notifyDataSetChanged();
                    }
                });
                dialogColor.create().show();
            }
        });


        ArrayList<String> sBrand = database.layBrand();
        String[] brand = sBrand.toArray(new String[sBrand.size()]);
        btnHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(ShopActivity.this);
                dialogColor.setItems(brand, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnHang.setText(brand[c]);

                        allPro.clear();
                        allPro.addAll(database.LocSanPham(btnHang.getText().toString(), btnLoai.getText().toString(), btnGia.getText().toString()));
                        proAdapter.notifyDataSetChanged();
                    }
                });
                dialogColor.create().show();
            }
        });


        String[] price = { "Thấp đến cao" , "Cao đến thấp" };
        btnGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(ShopActivity.this);
                dialogColor.setItems(price, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnGia.setText(price[c]);

                        allPro.clear();
                        allPro.addAll(database.LocSanPham(btnHang.getText().toString(), btnLoai.getText().toString(), btnGia.getText().toString()));
                        proAdapter.notifyDataSetChanged();
                    }
                });
                dialogColor.create().show();
            }
        });
    }

    @Override
    public void setOnItemClickListener(Products product) {
        Intent intentPro = new Intent(ShopActivity.this, ProductInfo.class);
        intentPro.putExtra("product", product);
        startActivity(intentPro);

    }


    public void SearchOnclickListener(View view) {
        Intent intent = new Intent(ShopActivity.this, SearchActivity.class);
        intent.putExtra("flag", "user");
        startActivity(intent);
    }

    public void AllProductOnclick(View view) {
        btnHang.setText("Hãng");
        btnLoai.setText("Loại");
        btnGia.setText("Giá");
        allPro.clear();
        allPro.addAll(database.layTatCaDuLieu());
        proAdapter.notifyDataSetChanged();
    }
}