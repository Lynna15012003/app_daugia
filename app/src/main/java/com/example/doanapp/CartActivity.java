package com.example.doanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanapp.adapter.CartAdapter;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Cart;
import com.example.doanapp.model.Products;
import com.example.doanapp.model.User;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    ArrayList<Cart> arrCart;
    RecyclerView rcvCart;
    CartAdapter cartAdapter;
//    TextView tvDelete;
//    Button btnBuy;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        db = new MyDatabase(CartActivity.this);
        rcvCart = (RecyclerView) findViewById(R.id.rcvGioHang);

        arrCart = db.selectCart(Login.getLogin());

        cartAdapter = new CartAdapter(this, arrCart, R.layout.item_cart);
        rcvCart.setAdapter(cartAdapter);

        rcvCart.setLayoutManager(new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false));
        rcvCart.addItemDecoration(new DividerItemDecoration(CartActivity.this, LinearLayoutManager.VERTICAL));

    }

    public void DeleteCartOnclick(View view) {
        for (int i = rcvCart.getChildCount() - 1; i >= 0; i--)
        {
            view = rcvCart.getChildAt(i);
            CheckBox chk = (CheckBox) view.findViewById(R.id.checkBox);
            if(chk.isChecked()) {
                Cart cart = arrCart.get(i);
                db.DeleteCart(cart);
                arrCart.clear();
                arrCart.addAll(db.selectCart(Login.getLogin()));
                cartAdapter.notifyDataSetChanged();
            }
        }
    }

    public void BuyOnclickListener(View view) {

        //if(Login.getLogin() == 0){
            Dialog dialog = new Dialog(CartActivity.this);

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
                    Intent intent = new Intent(CartActivity.this, Login.class);
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
                    else {
                        ArrayList<Cart> arrCartOrder = new ArrayList<Cart>();
                        for (int i = 0; i <= rcvCart.getChildCount() - 1; i++)
                        {
                            view = rcvCart.getChildAt(i);
                            CheckBox chk = (CheckBox) view.findViewById(R.id.checkBox);
                            if(chk.isChecked()) {
                                Cart cartC = arrCart.get(i);
                                arrCartOrder.add(cartC);
                                db.DeleteCart(cartC);
                            }
                        }

                        Intent intent = new Intent(CartActivity.this, PayProductActivity.class);
                        intent.putExtra("arrCartOrder", arrCartOrder);

                        if(Login.getLogin() != 0) {
                            db.UpdateUser(Login.getLogin(), edtName.getText().toString(), edtPhone.getText().toString(), edtAddress.getText().toString());
                        }

                        Login.setName(edtName.getText().toString());
                        Login.setPhone(edtPhone.getText().toString());
                        Login.setAddress(edtAddress.getText().toString());
                        startActivity(intent);

                    }
                }
            });
            dialog.show();
//        }else {
//            ArrayList<Cart> arrCartOrder = new ArrayList<Cart>();
//            for (int i = 0; i <= rcvCart.getChildCount() - 1; i++)
//            {
//                view = rcvCart.getChildAt(i);
//                CheckBox chk = (CheckBox) view.findViewById(R.id.checkBox);
//                if(chk.isChecked()) {
//                    Cart cartC = arrCart.get(i);
//                    arrCartOrder.add(cartC);
//                }
//            }
//
//
//            User user = db.selectUser(Login.getLogin());
//            Intent intent = new Intent(CartActivity.this, PayProductActivity.class);
//            intent.putExtra("arrCartOrder", arrCartOrder);
//            Login.setName(user.getNameUser());
//            Login.setPhone(user.getPhone());
//            Login.setAddress(user.getAddress());
//            startActivity(intent);
//        }

    }

    public void BackCartOnclickListener(View view) {

        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}