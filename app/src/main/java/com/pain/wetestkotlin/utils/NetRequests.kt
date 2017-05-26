package com.pain.wetestkotlin.utils

import com.pain.wetestkotlin.beans.ArticleTypeBean

import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.POST

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/5/25
 * 版本：1.0.0
 * 描述：
 */

interface NetRequests {
    @POST("/mobile/articleClass/list.json")
    fun gainArticleResult(): Observable<ApiResponse<ArticleTypeBean>>
}
