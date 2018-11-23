package com.example.shuaijia.databindingdemo.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class ObserverGoods {

    public ObservableField<String> name;
    public ObservableInt age;
    public ObservableBoolean sex;

    public ObserverGoods(String name, int age, boolean sex) {
        this.name = new ObservableField<>(name);
        this.age = new ObservableInt(age);
        this.sex = new ObservableBoolean(sex);
    }


//    public ObservableField<String> getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name.set(name);
//    }
//
//    public ObservableInt getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age.set(age);
//    }
//
//    public ObservableBoolean getSex() {
//        return sex;
//    }
//
//    public void setSex(boolean sex) {
//        this.sex.set(sex);
//    }
}
