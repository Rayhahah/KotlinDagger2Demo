package com.rayhahah.kotlindagger2demo

import android.util.Log

fun l(msg: Any) {
    Log.e("lzh", msg.toString())
}

fun Any.log() {
    Log.e("lzh", this.toString())
}