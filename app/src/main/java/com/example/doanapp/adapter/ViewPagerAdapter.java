package com.example.doanapp.adapter;

import android.graphics.Bitmap;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doanapp.Fragment.Fragment1;
import com.example.doanapp.Fragment.Fragment2;
import com.example.doanapp.Fragment.Fragment3;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Bitmap bitmapImg;

    public ViewPagerAdapter(FragmentManager fm, Bitmap bitmapImg) {
        super(fm);
        this.bitmapImg =bitmapImg;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new Fragment1(bitmapImg);
            case 1:
                return  new Fragment2(bitmapImg);
            case 2:
                return  new Fragment3(bitmapImg);

            default:
                return new Fragment1(bitmapImg);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}