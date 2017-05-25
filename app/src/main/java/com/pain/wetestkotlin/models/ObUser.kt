package com.pain.wetestkotlin.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.pain.wetestkotlin.BR

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/5/25
 * 版本：1.0.0
 * 描述：
 */

class ObUser : BaseObservable() {
    @get:Bindable
    var obname: String? = null
        set(obname) {
            field = obname
            notifyPropertyChanged(BR.obname)
        }
}
