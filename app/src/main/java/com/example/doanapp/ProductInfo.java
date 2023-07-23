package com.example.doanapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanapp.Fragment.Fragment1;
import com.example.doanapp.adapter.ViewPagerAdapter;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Cart;
import com.example.doanapp.model.Products;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductInfo extends AppCompatActivity {

    ViewPager vpPro;
    TabLayout tabLayout;
    ViewPagerAdapter viewAdap;
    TextView tvName, tvPrice, tvDes, tvQuantity;
    Button btnAddCart, btnColor, btnSize;
    ImageView subQuantity, sumQuantity;
    Products pro;
    MyDatabase db;
    Fragment1 fragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        AnhXa();



        Intent intent = getIntent();
        pro = (Products) intent.getSerializableExtra("product");

        try {
            InputStream is = this.getAssets().open(pro.getImagePro());
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            viewAdap = new ViewPagerAdapter(getSupportFragmentManager(), bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        vpPro.setAdapter(viewAdap);
        tabLayout.setupWithViewPager(vpPro);

        //vpPro.setBackgroundResource(R.drawable.adidas_boost_cloud1);
        tvName.setText(pro.getName());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(pro.getPrice());
        tvPrice.setText(price);
        tvDes.setText(pro.getDescription());



        String[] colors = pro.getColor().split(" ");
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogColor = new AlertDialog.Builder(ProductInfo.this);
                dialogColor.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int c) {
                        btnColor.setText(colors[c]);
                    }
                });
                dialogColor.create().show();
            }
        });


        String[] option = pro.getSize().split(" ");
        btnSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogSize = new AlertDialog.Builder(ProductInfo.this);
                dialogSize.setItems(option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btnSize.setText("Size " + option[i]);
                    }
                });
                dialogSize.create().show();
            }
        });


        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btnSize.getText().toString().equals("SIZE")){
                    Toast.makeText(ProductInfo.this, "Vui lòng chọn size!", Toast.LENGTH_LONG).show();
                } else if (btnColor.getText().toString().equals("MÀU SẮC")) {
                    Toast.makeText(ProductInfo.this, "Vui lòng chọn màu!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(ProductInfo.this, CartActivity.class);
                    Cart cart = new Cart(pro.getId(), Login.getLogin(), Integer.parseInt(tvQuantity.getText().toString()), btnColor.getText().toString(), btnSize.getText().toString());
                    db.CheckAndAddCart(cart);
                    startActivity(intent);
                }

            }
        });

    }


    private void AnhXa() {
        vpPro = (ViewPager) findViewById(R.id.vp_SP);
        tvName = (TextView) findViewById(R.id.tvTenSP);
        tvPrice = (TextView) findViewById(R.id.tvGia);
        tvDes = (TextView) findViewById(R.id.tvMota);
        tabLayout = findViewById(R.id.tablo_SP);
        vpPro = (ViewPager) findViewById(R.id.vp_SP);
        btnAddCart = (Button) findViewById(R.id.btnAddSP);
        btnColor = (Button) findViewById(R.id.btnColor);
        btnSize = (Button) findViewById(R.id.btnSize);
        tvQuantity = (TextView) findViewById(R.id.tvQuantityCart);
        sumQuantity = (ImageView) findViewById(R.id.sumQuantity);
        subQuantity = (ImageView) findViewById(R.id.subQuantity);
        db = new MyDatabase(ProductInfo.this);

    }

    public void SumQuantityOnclick(View view) {
        String quantity = tvQuantity.getText().toString();
        int intQuantity = Integer.parseInt(quantity);
        intQuantity++;
        tvQuantity.setText(String.valueOf(intQuantity));
    }

    public void SubQuantityOnclick(View view) {
        String quantity = tvQuantity.getText().toString();
        int intQuantity = Integer.parseInt(quantity);
        if(intQuantity != 1){
            intQuantity--;
            tvQuantity.setText(String.valueOf(intQuantity));
        }
    }

    public void IconCartInInfoOnclickListener(View view) {
        Intent intent = new Intent(ProductInfo.this, CartActivity.class);
        startActivity(intent);
    }

    public void BackInfoOnclickListener(View view) {
        onBackPressed();
    }

    public void btnMuaNgayOnclick(View view) {

        if(btnSize.getText().toString().equals("SIZE")){
            Toast.makeText(ProductInfo.this, "Vui lòng chọn size!", Toast.LENGTH_LONG).show();
        } else if (btnColor.getText().toString().equals("MÀU SẮC")) {
            Toast.makeText(ProductInfo.this, "Vui lòng chọn màu!", Toast.LENGTH_LONG).show();
        } else {

//            if(Login.getLogin() == 0) {
            Dialog dialog = new Dialog(ProductInfo.this);

            dialog.setContentView(R.layout.item_layout_thongtin);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            Button btnXacNhan = dialog.findViewById(R.id.btnXacnhan);
            TextInputEditText edtName = dialog.findViewById(R.id.edtName);
            TextInputEditText edtAddress = dialog.findViewById(R.id.edtAddress);
            TextInputEditText edtPhone = dialog.findViewById(R.id.edtPhone);
            TextView tvLoginInCart = dialog.findViewById(R.id.tvLoginInCart);
            TextView textHaveAccount = dialog.findViewById(R.id.textHaveAccount);

            edtName.setText(Login.getName());
            edtAddress.setText(Login.getAddress());
            edtPhone.setText(Login.getPhone());

            if (Login.getLogin() != 0) {
                textHaveAccount.setVisibility(View.GONE);
                tvLoginInCart.setVisibility(View.GONE);
            }

            tvLoginInCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProductInfo.this, Login.class);
                    startActivity(intent);
                }
            });

            btnXacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (edtName.getText().toString().trim().length() == 0){
                        edtName.setError("Tên không được bỏ trống!");
                        edtName.setFocusableInTouchMode(true);
                        edtName.setFocusable(true);
                        edtName.requestFocus();
                    }
                    else if (edtAddress.getText().toString().trim().length() == 0) {
                        edtAddress.setError("Địa chỉ không được bỏ trống!");
                        edtAddress.setFocusableInTouchMode(true);
                        edtAddress.setFocusable(true);
                        edtAddress.requestFocus();
                    }
                    else if(edtPhone.length() != 10){
                        edtPhone.setError("Số điện thoại phải bao gồm 10 số!");
                        edtPhone.setFocusableInTouchMode(true);
                        edtPhone.setFocusable(true);
                        edtPhone.requestFocus();
                    }

                    Cart cart = new Cart(pro.getId(), Integer.parseInt(tvQuantity.getText().toString()), btnColor.getText().toString(), btnSize.getText().toString());
                    ArrayList<Cart> arrCart = new ArrayList<Cart>();
                    arrCart.add(cart);

                    if(Login.getLogin() != 0) {
                        db.UpdateUser(Login.getLogin(), edtName.getText().toString(), edtPhone.getText().toString(), edtAddress.getText().toString());
                    }

                    Intent intent = new Intent(ProductInfo.this, PayProductActivity.class);
                    intent.putExtra("arrCartOrder", arrCart);
                    Login.setName(edtName.getText().toString());
                    Login.setPhone(edtPhone.getText().toString());
                    Login.setAddress(edtAddress.getText().toString());
                    startActivity(intent);


                }
            });
            dialog.show();
//            }else {
//                Cart cart = new Cart(pro.getId(), Login.getLogin(), Integer.parseInt(tvQuantity.getText().toString()), btnColor.getText().toString(), btnSize.getText().toString());
//
//                ArrayList<Cart> arrCart = new ArrayList<Cart>();
//                arrCart.add(cart);
//                Intent intent = new Intent(ProductInfo.this, PayProductActivity.class);
//                intent.putExtra("arrCartOrder", arrCart);
//                startActivity(intent);
//            }

        }
    }
}