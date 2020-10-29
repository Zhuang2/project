package com.example.wechatkotlin

class Msg(val context:String,val type:Int,val imageID:Int) {
    companion object{
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }

}