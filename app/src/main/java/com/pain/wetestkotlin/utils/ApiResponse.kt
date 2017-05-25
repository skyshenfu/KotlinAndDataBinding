package com.pain.wetestkotlin.utils

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/25
 *版本：1.0.0
 *描述：
 */
class ApiResponse<T : DataInterface>{
    var apiError: Int = 0
    var msg: String=""
    var data: T ?= null
}