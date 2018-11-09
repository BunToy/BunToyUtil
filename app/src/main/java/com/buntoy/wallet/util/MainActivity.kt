package com.buntoy.wallet.util

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.buntoy.wallet.util.AESUtil.fromBytesToHex
import com.buntoy.wallet.util.AESUtil.hexStringToByteArray



class MainActivity : AppCompatActivity() {
    private var log=LogUtil.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TimeUtil
        log.i(TimeUtil.getCurrentWeekday(Date()))

        //AESUtil
        val aesKey = AESUtil.initKey()
    }
}
