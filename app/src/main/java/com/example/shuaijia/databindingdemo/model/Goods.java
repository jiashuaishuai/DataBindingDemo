package com.example.shuaijia.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.shuaijia.databindingdemo.BR;

//单向数据绑定
public class Goods extends BaseObservable {

    //public直接修饰
    @Bindable
    public String name;
    private int age;
    @Bindable
    public String sex;


    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
        //之跟新当前字段
        notifyPropertyChanged(BR.name);
    }

    //private需要在个方法上修饰
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

