package com.example.wechatkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val wechatList = ArrayList<Wechat>()

    fun initWechat(){
        repeat(1){
            wechatList.add(Wechat("呆呆", "[微信红包]", R.drawable.dai))
            wechatList.add(Wechat("呆呆", "[语音]", R.drawable.one))
            wechatList.add(Wechat("微信支付", "微信支付凭证", R.drawable.zhifu))
            wechatList.add(Wechat("呆呆", "[OK]", R.drawable.onen4))
            wechatList.add(Wechat("呆呆", "[语音]", R.drawable.oneo))
            wechatList.add(Wechat("罗熙&夏温", "[语音]", R.drawable.qun))
            wechatList.add(Wechat("呆子", "[语音]", R.drawable.teow))
            wechatList.add(Wechat("呆子", "[语音]", R.drawable.twot))
            wechatList.add(Wechat("微信团队", "登录操作通知", R.drawable.tuandui))
            wechatList.add(Wechat("联合会", "[语音]", R.drawable.qunon))
            wechatList.add(Wechat("订阅号", "一句暖心话:....", R.drawable.ding))
            wechatList.add(Wechat("小完子", "[语音]", R.drawable.qunun))
            wechatList.add(Wechat("文件传输助手", "[文件]", R.drawable.wenjian))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()     //隐藏标题栏

        initWechat()

        val wechatAdapter = WechatAdapter(this, R.layout.wechat_item, wechatList)
        ListViewTest.adapter=wechatAdapter

        ListViewTest.setOnItemClickListener { _, _, i, _ ->
            val fruit = wechatList[i]
//            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()

            //跳转至聊天界面
            val intent=Intent(this,MainActivityWith::class.java)
            startActivity(intent)

        }
    }
}