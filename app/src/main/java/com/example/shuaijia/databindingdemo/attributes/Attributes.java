package com.example.shuaijia.databindingdemo.attributes;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * dataBinding自定义属性
 */
public class Attributes {

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(String color) {
        return new ColorDrawable(Color.parseColor(color));
    }

    /**
     * 以下方法会将布局文件中所有以@{String}方式引用到的String类型变量加上后缀-conversionString
     *
     * @param text
     * @return
     */
//    @BindingConversion
//    public static String conversionString(String text) {
//        return text + "-conversionString";
//    }
    @BindingConversion
    public static String converDoubleToString(double num) {
        return String.valueOf(num).concat("duble转String");
    }


    // 第一次的时候会调两次
    @BindingAdapter("data")
    public static void setData(TextView textView, final String data) {
        Log.e("MainActivity", "name：" + data);
        textView.setText(data);
        textView.setTextColor(Color.BLUE);
    }

    @BindingAdapter(value = {"imgUrl", "errorDrawable", "placeDrawable"}, requireAll = true)
    public static void setImageUrl(ImageView imageView, String url, int errorImg, Drawable placeImg) {
        Log.e("Attributes", url);
        imageView.setImageResource(errorImg);
        imageView.setImageDrawable(placeImg);
    }


    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int oldPadding, int newPadding) {
        Log.e("Attributes", "oldPadding:" + oldPadding + "newPadding" + newPadding);
        if (oldPadding != newPadding) {
            view.setPadding(newPadding,
                    view.getPaddingTop(),
                    view.getPaddingRight(),
                    view.getPaddingBottom());
        }
    }

}
