package com.rayhahah.kotlindagger2demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rayhahah.kotlindagger2demo.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toNextActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
