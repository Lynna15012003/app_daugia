package com.example.doanapp.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.doanapp.MainActivity;
import com.example.doanapp.R;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Products;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.io.InputStream;

public class EditPro extends AppCompatActivity {

    TextInputEditText edNamePro, edDescription, edPricepro, edImagepro, edSizepro, edColor;
    Button btnCateAdminAdd, btnBrandAdminAdd, btnXoa, btnSua;
    MyDatabase db;
    Products pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pro);

        AnhXa();
        db = new MyDatabase(EditPro.this);

        Intent intent = getIntent();
        pro = (Products) intent.getSerializableExtra("productAdmin");

        String sCate = db.layNameCate(pro.getCategory());

        String sbrand = db.layNameBrand(pro.getBrand());

        edNamePro.setText(pro.getName());
        edDescription.setText(pro.getDescription());
        btnCateAdminAdd.setText(sCate);
        btnBrandAdminAdd.setText(sbrand);
        edPricepro.setText(String.valueOf(pro.getPrice()));
        edImagepro.setText(pro.getImagePro());
        edSizepro.setText(pro.getSize());
        edColor.setText(pro.getColor());
    }

    public void XoaProAdmin(View view) {
        db.DeletePro(pro);
        Toast.makeText(EditPro.this, "Đã xóa", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditPro.this, MainActivityAdmin.class);
        startActivity(intent);
    }

    public void SuaProAdmin(View view) {
        String name = edNamePro.getText().toString();
        String des = edDescription.getText().toString();

        int cate = db.layIdCate(btnCateAdminAdd.getText().toString());
        int brand = db.layIdBrand(btnBrandAdminAdd.getText().toString());

        int price = Integer.parseInt(edPricepro.getText().toString());
        String image = edImagepro.getText().toString();

        try {
            InputStream is = EditPro.this.getAssets().open(image);
            is.close();
        } catch (IOException e) {
            image = "adidas_boost_cloud1.jpg";
        }

        String size = edSizepro.getText().toString();
        String color = edColor.getText().toString();

        Products products = new Products(pro.getId(), name, des, cate, brand, price,image, size, color);
        db.EditPro(products);

        Toast.makeText(EditPro.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditPro.this, MainActivityAdmin.class);
        startActivity(intent);

    }

    private void AnhXa() {
        edNamePro = (TextInputEditText) findViewById(R.id.edNamePro2);
        edDescription = (TextInputEditText) findViewById(R.id.edDescription2);
        edPricepro = (TextInputEditText) findViewById(R.id.edPricepro2);
        edImagepro = (TextInputEditText) findViewById(R.id.edImagepro2);
        edSizepro = (TextInputEditText) findViewById(R.id.edSizepro2);
        edColor = (TextInputEditText) findViewById(R.id.edColor2);
        btnCateAdminAdd = (Button) findViewById(R.id.btnCateAdminAdd2);
        btnBrandAdminAdd = (Button) findViewById(R.id.btnBrandAdminAdd2);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnSua = (Button) findViewById(R.id.btnSua);
    }

    public void IconHomeAdminOnclickListener(View view) {
        Intent intent = new Intent(EditPro.this, MainActivityAdmin.class);
        startActivity(intent);
    }
}