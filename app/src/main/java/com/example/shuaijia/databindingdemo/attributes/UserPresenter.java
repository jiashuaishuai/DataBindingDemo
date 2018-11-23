package com.example.shuaijia.databindingdemo.attributes;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuaijia.databindingdemo.User;
import com.example.shuaijia.databindingdemo.model.ObserverGoods;

public class UserPresenter {

    public void onUserNameClick(View view, User user) {
        Toast.makeText(view.getContext(), "用户名：" + user.getName(), Toast.LENGTH_SHORT).show();
    }

    public void click(View view) {
        Toast.makeText(view.getContext(), "点击click", Toast.LENGTH_SHORT).show();
    }

    public void click2() {
        Log.e("UserPresenter", "click2被点击");
    }

    public String getTextStr() {
        return "点我点我";
    }


    public void afterTextChanged(Editable s, ObserverGoods user) {
        user.name.set(s.toString());
    }

    public void textCHanged1(Editable s) {
        Log.e("UserPresenter", s.toString());
    }


}
