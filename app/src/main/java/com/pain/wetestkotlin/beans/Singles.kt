package com.pain.wetestkotlin.beans

import java.io.Serializable

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/25
 *版本：1.0.0
 *描述：
 */
class SingleArticle:Serializable{
     var id: Long = 0
     var ownerId: Long =0
     var classid: Long = 0
     var displayorder: Int = 0
     var name: String = ""
}