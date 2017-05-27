package com.pain.wetestkotlin.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.pain.wetestkotlin.models.DbUser
import com.pain.wetestkotlin.models.ObUser
import com.pain.wetestkotlin.R
import com.pain.wetestkotlin.beans.ArticleTypeBean
import com.pain.wetestkotlin.databinding.ActivityKmainBinding
import com.pain.wetestkotlin.utils.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/25
 *版本：1.0.0
 *描述：
 */
class KMainActivity : AppCompatActivity() {
    var dataBinding: ActivityKmainBinding?= null
    var  user: ObUser?=null
    var dbUser: DbUser?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user= ObUser()
        dbUser= DbUser()
        user!!.obname="23333"
        dbUser!!.dbname="66666"
        dataBinding= DataBindingUtil.setContentView(this, R.layout.activity_kmain)
        dataBinding!!.presenter=Presenter()
        dataBinding!!.user=user
        dataBinding!!.doublebindUser=dbUser


    }
    inner class Presenter{
         fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int){
             user!!.obname=s.toString()
        }

        /**
         * rxjava2的坑：在rxjava2中observable对应的是observer
         *                       flowable对应的是subscriber,并且在onSubscribe中需要显示调用request否则不会进行其他操作
         */
        fun onClick(view: View){
            when(view.id){
                R.id.button_one->oneclick()
                R.id.button_two->twoclick()

            }
        }

         fun oneclick() {
            val subscriber = object : Subscriber<ApiResponse<ArticleTypeBean>> {
                override fun onSubscribe(s: Subscription?) {
                    s!!.request(Long.MAX_VALUE)
                }

                override fun onNext(t: ApiResponse<ArticleTypeBean>?) {
                    Log.e("data", "msg2")
                }

                override fun onError(e: Throwable?) {
                    Log.e("data", "msg3")
                }

                override fun onComplete() {
                    Log.e("data", "msg4")
                }

            }
            NetApi.instance.gainArticleResult()
                    .compose(SchedulersUtil.iotomain())
                    .subscribe(subscriber)
        }
         fun twoclick(){
            RxBus.getInstance().post(Event("hello"))
        }
    }


}