package com.pain.wetestkotlin;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/5/25
 * 版本：1.0.0
 * 描述：
 */

public class DbUser extends BaseObservable {
    private  String dbname;
    @Bindable
    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
        notifyPropertyChanged(BR.dbname);
    }
}
