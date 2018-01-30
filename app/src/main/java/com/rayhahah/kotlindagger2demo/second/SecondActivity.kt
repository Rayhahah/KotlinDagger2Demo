package com.rayhahah.kotlindagger2demo.second

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.rayhahah.kotlindagger2demo.R
import com.rayhahah.kotlindagger2demo.base.BaseActivity
import com.rayhahah.kotlindagger2demo.component.DaggerSecondComponent
import com.rayhahah.kotlindagger2demo.log
import com.rayhahah.kotlindagger2demo.module.SecondModule
import javax.inject.Inject

class SecondActivity : BaseActivity() {

    @Inject
    lateinit var mContext: Context
    @Inject
    lateinit var mActivity: Activity
    @Inject
    lateinit var mSecondService: SecondService

//    @field:[AgeQualifier]
//    @AgeQualifier
    @Inject
    lateinit var mPhone: Phone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initInjection()
        mSecondService.getSecondInfo().log()
        mPhone.log()
    }

    private fun initInjection() {
        DaggerSecondComponent.builder().activityComponent(mActivityComponent)
                .secondModule(SecondModule()).build().inject(this)
    }
}
