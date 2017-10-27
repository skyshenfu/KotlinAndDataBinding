package com.pain.wetestkotlin

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.pain.wetestkotlin.utils.Event
import com.pain.wetestkotlin.utils.RxBus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/27
 *版本：1.0.0
 *描述：
 */
class App:Application(){
    override fun onCreate() {
        super.onCreate()
        RxBus.getInstance().toObservable(Event::class.java)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t ->
                    if (t!!.name == "hello2"){
                        Toast.makeText(applicationContext,"来啦",Toast.LENGTH_SHORT).show()
                        Log.e("aaa","bb")
                    }else{
                        Log.e("aaa","cc")
                    }
                }
        RxBus.getInstance().toObservable(Event::class.java)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Consumer<Event>{
                    override fun accept(t: Event) {
                        Toast.makeText(applicationContext,"消费了",Toast.LENGTH_SHORT).show()

                    }

                })
    }
}