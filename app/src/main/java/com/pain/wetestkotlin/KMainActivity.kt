package com.pain.wetestkotlin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.pain.wetestkotlin.databinding.ActivityKmainBinding

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/25
 *版本：1.0.0
 *描述：
 */
class KMainActivity : AppCompatActivity() {
    var dataBinding:ActivityKmainBinding ?= null
    var  user:ObUser?=null
    var dbUser:DbUser?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user= ObUser()
        dbUser=DbUser()
        user!!.obname="23333"
        dbUser!!.dbname="66666"
        dataBinding=DataBindingUtil.setContentView(this,R.layout.activity_kmain)
        dataBinding!!.presenter=Presenter()
        dataBinding!!.user=user
        dataBinding!!.doublebindUser=dbUser


    }
    inner class Presenter{
         fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int){
             user!!.obname=s.toString()
        }
        fun onTestDoubleBind(dbUser: DbUser){
            Log.e("here",dbUser.dbname)
        }
    }


}