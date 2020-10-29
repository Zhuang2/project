package com.example.wechatkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_with.*
import kotlinx.android.synthetic.main.msg_bom.*

class MainActivityWith : AppCompatActivity(){

    private var msgList = ArrayList<Msg>()

    private var adapter: MsgAdapter?=null

    private fun initMsg() {
        repeat(2)
        {
            msgList.add(Msg("肚子饿了", 0, R.drawable.onen4))
            msgList.add(Msg("点了麻辣烫", 0,R.drawable.onen4))
            msgList.add(Msg("这样子", 1,R.drawable.one))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with)
        supportActionBar ?.hide()        //隐藏标题栏


        initMsg()
        val layoutManager = LinearLayoutManager(this)
       msgRecyclerView.layoutManager = layoutManager
       val adapter = MsgAdapter(msgList)
//        //为设配器添加缩放动画
//        val adapter1 = ScaleInAnimationAdapter(adapter).apply {
//            //设置动画时长
//            setDuration(500)
//            //设置动画重复
//            setFirstOnly(false)
//        }
//        //叠加上面的动画，添加淡出动画
//        val adapter2 =AlphaInAnimationAdapter(adapter1).apply {
//            setDuration(300)
//            setFirstOnly(false)
//        }

        msgRecyclerView.adapter=adapter

        msgSend.setOnClickListener {
            val text:String = msgText.text.toString()
            if (text.isNotEmpty()){
                //判断两个数据源是否一致
                val list = adapter.getList()
                if (msgList.size != list.size)msgList = list as ArrayList<Msg>
                //增加数据到数据源
                msgList.add(Msg(text,1,R.drawable.wei))
                //通知设配器增加了数据
                adapter.notifyItemRangeInserted(msgList.size-1,1)
                //滚动到最新数据的位置上
                msgRecyclerView.scrollToPosition(msgList.size-1)
                //清空输入框中的内容
                msgText.setText("")
            }
        }

        rootLayout.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (oldBottom != -1 && oldBottom > bottom){
                msgRecyclerView.requestLayout()
                msgRecyclerView.post{msgRecyclerView.scrollToPosition(msgList.size-1)}
            }
        }


    }

}