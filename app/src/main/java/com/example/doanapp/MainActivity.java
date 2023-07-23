package com.example.doanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanapp.adapter.BrandAdapter;
import com.example.doanapp.adapter.ProductAdapter;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Brand;
import com.example.doanapp.model.Cart;
import com.example.doanapp.model.Products;
import com.example.doanapp.model.User;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.Listener {

    Toolbar toolbarMain;
    DrawerLayout drawerLayoutMain;
    NavigationView nvMain;
    ImageView iconSearch, iconCart;
    RecyclerView rcvTheThao, rcvSneaker, rcvRunning, rcvBongDa, rcvBrand;
    ArrayList<Products> sneakerPro, theThaoPro, bongDaPro, runningPro;
    ProductAdapter sneakerAdapter, theThaoAdapter, bongDaAdapter, runningAdapter;
    ArrayList<Brand> brand;
    BrandAdapter brandAdapter;
    TextView tvHomeMenu, tvAllProMenu, tvCartMenu, tvFavoriteMenu, tvLoginMain, tvLogoutMain;
    public static MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        ActionToolBar();

        RecyclerViewMain();

        ViewPagerProduct();

        tvLoginMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });


        if(Login.getLogin() != 0){
            tvLoginMain.setText(Login.getName());
            tvLogoutMain.setVisibility(View.VISIBLE);

            tvLogoutMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Login.setLogin(0);
                    Login.setName(null);
                    Login.setPhone(null);
                    Login.setAddress(null);
                    tvLoginMain.setText("Đăng nhập");
                    tvLogoutMain.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void ViewPagerProduct() {
    }

    private void RecyclerViewMain() {

//        rcvTheThao.setHasFixedSize(true);
//        rcvSneaker.setHasFixedSize(true);
//        rcvRunning.setHasFixedSize(true);
//        rcvBongDa.setHasFixedSize(true);


       // brand = database.brands();
        //brandAdapter = new BrandAdapter(brand, MainActivity.this, MainActivity.this);
        //rcvBrand.setAdapter(brandAdapter);
        //rcvBrand.setLayoutManager(new GridLayoutManager(this, 2));


        sneakerPro = database.layDuLieuCategory(2);
        sneakerAdapter = new ProductAdapter(MainActivity.this, sneakerPro, MainActivity.this);
        rcvSneaker.setAdapter(sneakerAdapter);
        rcvSneaker.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        // rcvTheThao.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));


        theThaoPro = database.layDuLieuCategory(1);
        theThaoAdapter = new ProductAdapter(MainActivity.this, theThaoPro, MainActivity.this);
        rcvTheThao.setAdapter(theThaoAdapter);
        rcvTheThao.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));


        bongDaPro = database.layDuLieuCategory(4);
        bongDaAdapter = new ProductAdapter(MainActivity.this, bongDaPro, MainActivity.this);
        rcvBongDa.setAdapter(bongDaAdapter);
        rcvBongDa.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));


        runningPro = database.layDuLieuCategory(3);
        runningAdapter = new ProductAdapter(MainActivity.this, runningPro, MainActivity.this);
        rcvRunning.setAdapter(runningAdapter);
        rcvRunning.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));




    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayoutMain.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        drawerLayoutMain = (DrawerLayout) findViewById(R.id.drawerMain);
        nvMain = (NavigationView) findViewById(R.id.nvMenu);
        iconSearch = (ImageView) findViewById(R.id.imvSearch);
        iconCart = (ImageView) findViewById(R.id.imgCart);
        rcvTheThao = (RecyclerView)findViewById(R.id.rcvTheThao);
        rcvSneaker = (RecyclerView)findViewById(R.id.rcvSneaker);
        rcvRunning = (RecyclerView)findViewById(R.id.rcvRunning);
        rcvBongDa = (RecyclerView)findViewById(R.id.rcvBongDa);
       // rcvBrand = (RecyclerView) findViewById(R.id.rcvBrand);
        tvAllProMenu = (TextView) findViewById(R.id.tvMenuAllPro);
        tvHomeMenu = (TextView) findViewById(R.id.tvMenuHome);
        tvCartMenu = (TextView) findViewById(R.id.tvMenuCart);
        tvFavoriteMenu = (TextView) findViewById(R.id.tvMenuFavority);
        tvLoginMain = (TextView) findViewById(R.id.tvLoginMain);
        tvLogoutMain = (TextView) findViewById(R.id.tvLogoutMain);
        database = new MyDatabase(this);
    }

    @Override
    public void setOnItemClickListener(Products product) {

        Intent intentPro = new Intent(MainActivity.this, ProductInfo.class);
        intentPro.putExtra("product", product);
        startActivity(intentPro);

    }

 //   @Override
 //   public void setOnItemBrandClick(Brand brand) {

 //       Intent intentPro = new Intent(MainActivity.this, ShopActivity.class);
 //       ArrayList<Products> tmp = new ArrayList<Products>();
  //      tmp = database.layDuLieuBrand(brand.getId());
  //      intentPro.putExtra("pro", tmp);
  //      startActivity(intentPro);
   // }

    public void itemMenuHomeOnClick(View view) {
    }

    public void itemMenuAllProOnClick(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        ArrayList<Products> tmp = new ArrayList<Products>();
        tmp = database.layTatCaDuLieu();
        intent.putExtra("pro", tmp);
        startActivity(intent);
    }

    public void itemMenuCartOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);

    }


    public void IconSearchOnclickListener(View view) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        intent.putExtra("flag", "user");
        startActivity(intent);
    }

    public void IconCartOnclickListener(View view) {

        Cart cart = null;
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        intent.putExtra("cart", cart);
        startActivity(intent);
    }

    public void itemMenuOrderOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, OrderDetailActivity.class);
        startActivity(intent);
    }
}