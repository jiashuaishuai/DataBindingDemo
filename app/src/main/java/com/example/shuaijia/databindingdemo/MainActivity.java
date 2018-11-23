package com.example.shuaijia.databindingdemo;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableList;
import android.databinding.ObservableMap;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shuaijia.databindingdemo.attributes.UserPresenter;
import com.example.shuaijia.databindingdemo.databinding.ActivityMainBinding;
import com.example.shuaijia.databindingdemo.model.Goods;
import com.example.shuaijia.databindingdemo.model.ObserverGoods;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    //
//    //注意这个地方static
//    @BindingAdapter("data")
//    public static void setData(TextView textView, final String data) {
//        Log.e(TAG, "name：" + data);
//        textView.setText(data);
//        textView.setTextColor(Color.BLUE);
//    }
    ActivityMainBinding activityMainBinding;
    private Goods goods;
    private ObserverGoods observerGoods;

    private ObservableList<String> observableList = new ObservableArrayList<>();
    private ObservableMap<String, String> observableMap = new ObservableArrayMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setSex(false);
        List<String> par = new ArrayList<>();
        par.add(null);
        par.add("测试数据");
        activityMainBinding.setParents(par);

        Map<String, String> maptest = new HashMap<>();
        maptest.put("mapTest", "哈哈哈哈");

        activityMainBinding.setMap(maptest);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                activityMainBinding.setData("测试自定义");
                User user = new User("绑定", 1);
                activityMainBinding.setUserInfo(user);
            }
        }, 5000);

        Log.e(TAG, "onCreate");
//        activityMainBinding.name.setTextColor(Color.BLUE);
        goods = new Goods();
        goods.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.e(TAG, "???：：" + propertyId);
                //更新多个的时候propertyId=0，未知
                switch (propertyId) {
                    case BR.name:
                        Log.e(TAG, "BR.name");
                        break;
                    case BR.age:
                        Log.e(TAG, "BR.age");
                        break;
                    case BR.sex:
                        Log.e(TAG, "BR.sex");
                        break;
                }
            }
        });
        activityMainBinding.setGood(goods);
        observerGoods = new ObserverGoods("a", 1, false);
        activityMainBinding.setObserverGoods(observerGoods);

        activityMainBinding.setObservableList(observableList);
        activityMainBinding.setObservableMap(observableMap);
        activityMainBinding.setUserPresenter(new UserPresenter());

    }

    public void singleupdate(View view) {
        goods.setAge(14);
        goods.setName("名字跟新" + new Random().nextInt(100));
    }

    public void multipleUpdates(View view) {
        goods.setAge(new Random().nextInt(100));
        goods.setSex("性别更新" + new Random().nextInt(100));
        goods.notifyChange();
    }

    public void observableUpdates(View view) {
        observerGoods.name.set("乌拉" + new Random().nextInt(100));
        observerGoods.sex.set(true);
        observerGoods.age.set(19);
    }

    public void observableCollectionUpdate(View view) {
        observableList.add("第一条数据");
        observableMap.put("mp", "mp数据");

    }





    Handler h = new Handler();

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

}
