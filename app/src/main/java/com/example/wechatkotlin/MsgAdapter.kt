package com.example.wechatkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(private var msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

    //在该方法中返回当前消息所对应的
    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == Msg.TYPE_RECEIVED) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            MsgViewHolder.LeftViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            val rightViewHolder = MsgViewHolder.RightViewHolder(view)
            //设置长按事件监听器
            rightViewHolder.itemView.setOnLongClickListener {
               msgList -= msgList[rightViewHolder.adapterPosition]
               notifyItemRemoved(rightViewHolder.adapterPosition)
                true
            }
            rightViewHolder
        }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is MsgViewHolder.LeftViewHolder -> {
                holder.leftImg.setImageResource(msg.imageID)
                holder.leftMsg.text = msg.context
            }
        }
        when (holder) {

            is MsgViewHolder.RightViewHolder -> {
                holder.rightImg.setImageResource(msg.imageID)
                holder.rightMsg.text = msg.context
            }
        }
    }

    override fun getItemCount() = msgList.size

    fun  getList() = msgList      //获取设配器的数据源

}