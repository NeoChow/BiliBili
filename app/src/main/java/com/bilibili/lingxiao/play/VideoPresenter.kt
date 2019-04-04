package com.bilibili.lingxiao.play

import com.bilibili.lingxiao.HttpTrans
import com.bilibili.lingxiao.home.recommend.RecommendView
import com.camera.lingxiao.common.app.BasePresenter
import com.camera.lingxiao.common.observer.HttpRxCallback

class VideoPresenter : BasePresenter<RecommendView, IntroduceFragment>{
    var httpTrans : HttpTrans

    constructor(view: RecommendView, fragment: IntroduceFragment):super(view, fragment){
        httpTrans = HttpTrans(fragment)
    }

    fun getDetailInfo(page:Int,id:String){
        httpTrans.getDetailInfo(page,id,object :HttpRxCallback<Any>(){
            override fun onSuccess(res: Any?) {
                var lists = res as Array<*>
                mView?.onGetVideoDetail(lists[0] as VideoDetailData)
            }

            override fun onError(code: Int, desc: String?) {
                mView?.showToast(desc)
            }

            override fun onCancel() {

            }

        })
    }
}