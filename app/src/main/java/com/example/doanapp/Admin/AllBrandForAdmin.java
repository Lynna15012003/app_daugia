package com.example.doanapp.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.doanapp.R;
import com.example.doanapp.adapter.BrandAdapter;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Brand;

import java.util.ArrayList;

public class AllBrandForAdmin extends AppCompatActivity implements BrandAdapter.Listener{

    ArrayList<Brand> arrBrand;
    BrandAdapter brandAdapter;
    RecyclerView rcvBrandAdmin;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_brand_for_admin);

        rcvBrandAdmin = (RecyclerView) findViewById(R.id.rcvBrandAdmin);
        db = new MyDatabase(AllBrandForAdmin.this);
        arrBrand = db.brands();
        brandAdapter = new BrandAdapter(arrBrand, AllBrandForAdmin.this, AllBrandForAdmin.this);
        rcvBrandAdmin.setAdapter(brandAdapter);
        rcvBrandAdmin.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void setOnItemBrandClick(Brand brand) {
        Intent intent = new Intent(AllBrandForAdmin.this, EditBrand.class);
        intent.putExtra("brandAdmin", brand);
        startActivity(intent);
    }
}