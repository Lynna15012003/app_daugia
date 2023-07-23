package com.example.doanapp.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.doanapp.R;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Brand;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.io.InputStream;

public class AddBrand extends AppCompatActivity {

    TextInputEditText edtNameBrand, edtImageBrand;
    Button btnAddBrand;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_brand);

        edtNameBrand = (TextInputEditText) findViewById(R.id.edtNameBrand);
        edtImageBrand = (TextInputEditText) findViewById(R.id.edtImageBrand);
        btnAddBrand = (Button) findViewById(R.id.btnAddBrand);
        db = new MyDatabase(AddBrand.this);

        btnAddBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtNameBrand.getText().toString();
                String image = edtImageBrand.getText().toString();

                try {
                    InputStream is = AddBrand.this.getAssets().open(image);
                    is.close();
                } catch (IOException e) {
                    image = "logo_login.jpg";
                    Toast.makeText(AddBrand.this, "Ảnh không tồn tại", Toast.LENGTH_SHORT).show();
                }

                Brand brand = new Brand(0, name, image);
                db.AddBrand(brand);
                Toast.makeText(AddBrand.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddBrand.this, MainActivityAdmin.class);
                startActivity(intent);
            }
        });
    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(AddBrand.this, MainActivityAdmin.class);
        startActivity(intent);
    }
}