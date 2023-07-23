package com.example.doanapp.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.doanapp.R;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Brand;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.io.InputStream;

public class EditBrand extends AppCompatActivity {

    TextInputEditText edtNameBrand, edtImgBrand;
    Brand brand;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_brand);

        edtNameBrand = (TextInputEditText) findViewById(R.id.edtNameBrand);
        edtImgBrand = (TextInputEditText) findViewById(R.id.edtImgBrand);
        db = new MyDatabase(EditBrand.this);

        Intent intent = getIntent();
        brand = (Brand) intent.getSerializableExtra("brandAdmin");

        edtNameBrand.setText(brand.getNameBrand());
        edtImgBrand.setText(brand.getImageBrand());

    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(EditBrand.this, MainActivityAdmin.class);
        startActivity(intent);
    }

    public void SuaBrandAdminOnclick(View view) {

        String name = edtNameBrand.getText().toString().trim();
        String img = edtImgBrand.getText().toString().trim();

        try {
            InputStream is = EditBrand.this.getAssets().open(img);
            is.close();
        } catch (IOException e) {
            img = brand.getImageBrand();
            Toast.makeText(this, "Ảnh không tồn tại", Toast.LENGTH_SHORT).show();
        }

        Brand brand2 = new Brand(brand.getId(), name, img );
        db.EditBrand(brand2);

        Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditBrand.this, MainActivityAdmin.class);
        startActivity(intent);
    }
}