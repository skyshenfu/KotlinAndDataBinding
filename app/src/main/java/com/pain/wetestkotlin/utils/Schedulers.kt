package com.pain.wetestkotlin.utils

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/26
 *版本：1.0.0
 *描述：
 */
class SchedulersUtil{
    companion object{
        fun <T> iotomain():ObservableTransformer<T,T>{
         return ObservableTransformer<T, T> { upstream ->
             upstream!!.subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
         }
        }
    }
}