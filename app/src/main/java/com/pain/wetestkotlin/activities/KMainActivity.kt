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
import com.pain.wetestkotlin.utils.ApiResponse
import com.pain.wetestkotlin.utils.NetApi
import io.reactivex.FlowableSubscriber
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
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
        fun onClick1(){
            Log.e("here click","hahahahah")
            val observer=object :FlowableSubscriber<ApiResponse<ArticleTypeBean>>{
                override fun onSubscribe(s: Subscription?) {
                    Log.e("here","data0")
                }

                override fun onError(e: Throwable?) {
                    Log.e("here","data1")
                }

                override fun onNext(t: ApiResponse<ArticleTypeBean>?) {
                    Log.e("here","data2")
                }

                override fun onComplete() {
                    Log.e("here","data3")
                }
            }
            NetApi.instance.getArticleResult()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)

        }
    }


}