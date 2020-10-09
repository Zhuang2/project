package com.example.wechatkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class WechatAdapter(context: Context, private val resource: Int, data: MutableList<Wechat>) :
    ArrayAdapter<Wechat>(context, resource, data) {

    private val resourceId = resource

    inner class ViewHolder(val wechatImage:ImageView,val wechatName:TextView,val wechatCont :TextView, val wechatTime:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder:ViewHolder

        val view:View
        if (convertView == null){
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
            val wechatImage:ImageView = view.findViewById(R.id.wechatImage)
            val wechatName:TextView = view.findViewById(R.id.wechatName)
            val wechatCont:TextView = view.findViewById(R.id.wechatCont)
            val wechatTime:TextView = view.findViewById(R.id.wechatTime)

            viewHolder = ViewHolder(wechatImage, wechatName,wechatCont,wechatTime)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder=view.tag as ViewHolder
        }



        val wechat = getItem(position)
        if(wechat != null){


            viewHolder.wechatImage.setImageResource(wechat.imageID)
            viewHolder.wechatName.text = wechat.name
            viewHolder.wechatCont.text = wechat.content
            viewHolder.wechatTime.text = getTime()
        }
        return view

    }
    fun getTime():String{
        val data = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return dateFormat.format(data)
    }
}