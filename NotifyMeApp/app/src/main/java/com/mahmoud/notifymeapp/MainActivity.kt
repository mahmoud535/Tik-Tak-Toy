package com.mahmoud.notifymeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var notifycationhilper:Notifycationhilper?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notifycationhilper= Notifycationhilper(this)
    }

    fun ch1click(view: View) {
        notifycationhilper!!.Notify(1,
            notifycationhilper!!.getNotification1("First",etMessage.text.toString()))
    }
    fun ch2click(view: View) {
        notifycationhilper!!.Notify(2,
            notifycationhilper!!.getNotification2("Second",etMessage.text.toString()))
    }
    fun ch3click(view: View) {
        notifycationhilper!!.Notify(3,
            notifycationhilper!!.getNotification3("Third",etMessage.text.toString()))
    }
}