package com.pain.wetestkotlin.utils

import com.pain.wetestkotlin.beans.ArticleTypeBean
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by zty
 *个人github地址：http://www.github.com/skyshenfu
 *日期：2017/5/25
 *版本：1.0.0
 *描述：
 */
class NetApi {
    var retrofit:Retrofit?=null
    var httpClientBuilder: OkHttpClient.Builder?=null
    var netRequest:NetRequests?=null
    companion object{
        val instance by lazy(LazyThreadSafetyMode.NONE){
            NetApi()
        }
    }
    private constructor(){
        httpClientBuilder=OkHttpClient.Builder().addInterceptor(RequestInterceptor())
        retrofit=Retrofit.Builder().client((httpClientBuilder as OkHttpClient.Builder?)!!.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://all-help.com/")
                .build()
        netRequest=retrofit!!.create(NetRequests::class.java)

    }

    fun getArticleResult(): Flowable<ApiResponse<ArticleTypeBean>> {
        return netRequest!!.getArticleResult()
    }
}