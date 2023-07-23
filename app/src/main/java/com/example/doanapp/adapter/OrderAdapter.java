package com.example.doanapp.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanapp.R;
import com.example.doanapp.db.MyDatabase;
import com.example.doanapp.model.Cart;
import com.example.doanapp.model.Order;
import com.example.doanapp.model.Products;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ProductVH>{
    Activity context = null;
    ArrayList<Order> arrOrder = null;
    MyDatabase db;
    int layoutid;

    public OrderAdapter(Activity context, ArrayList<Order> arrOrder, int layoutid)
    {
        this.db = new MyDatabase(context);
        this.context = context;
        this.arrOrder = arrOrder;
        this.layoutid = layoutid;
    }

    @NonNull
    @Override
    public OrderAdapter.ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutid, parent,false);
        return new OrderAdapter.ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ProductVH holder, int position) {
        Order order = arrOrder.get(position);
        Products pro = db.getInfoPro(order.getIdProOrder());
        try {
            InputStream is = context.getAssets().open(pro.getImagePro());
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.imgPro.setImageBitmap(bitmap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        holder.tvName.setText(pro.getName());

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String price = currencyVN.format(pro.getPrice());
        String size = order.getSize();
        String color = order.getColor();
        holder.tvGia.setText(price);
        holder.tvSize.setText(size);
        holder.tvColor.setText(color);
        holder.tvSoLuong.setText("x" + order.getQuantity());
    }


    @Override
    public int getItemCount() {
        return arrOrder.size();
    }
    class ProductVH extends RecyclerView.ViewHolder {

        ImageView imgPro;
        TextView tvName, tvGia, tvSize, tvColor, tvSoLuong;

        public ProductVH(@NonNull View itemView) {
            super(itemView);

            imgPro = (ImageView) itemView.findViewById(R.id.imgCartList);
            tvName = (TextView) itemView.findViewById(R.id.tvTenSP_Cart);
            tvGia = (TextView) itemView.findViewById(R.id.tvGia_Cart);
            tvSize = (TextView) itemView.findViewById(R.id.tvSize_Cart);
            tvColor = (TextView) itemView.findViewById(R.id.tvMauSP_Cart);
            tvSoLuong = (TextView) itemView.findViewById(R.id.tvSoLuong);
        }

    }
}
