package com.mahmoud.notifymeapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color

class Notifycationhilper(context: Context):ContextWrapper(context){
val manager:NotificationManager by lazy {
    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
}
init {
    //first channel
    val chan1=NotificationChannel(first_chaNNel,"first_chaNNel",NotificationManager.IMPORTANCE_DEFAULT)
    chan1.lightColor=Color.GREEN
    chan1.lockscreenVisibility=Notification.VISIBILITY_PRIVATE
    manager.createNotificationChannel(chan1)
 //second channel
    val chan2=NotificationChannel(Second_chaNNel,"Second_chaNNel",NotificationManager.IMPORTANCE_DEFAULT)
    chan2.lightColor=Color.GREEN
    chan2.lockscreenVisibility=Notification.VISIBILITY_PRIVATE
    manager.createNotificationChannel(chan2)
  //theard channel
    val chan3=NotificationChannel(therd_chaNNel,"Third_chaNNel",NotificationManager.IMPORTANCE_DEFAULT)
    chan3.lightColor=Color.GREEN
    chan3.lockscreenVisibility=Notification.VISIBILITY_PRIVATE
    manager.createNotificationChannel(chan3)
}

fun getNotification1(title:String,body:String):Notification.Builder{
    return Notification.Builder(applicationContext,first_chaNNel)
        .setContentText(body)
        .setContentTitle(title)
        .setSmallIcon(R.drawable.k1)
        .setAutoCancel(true)

}

    fun getNotification2(title:String,body:String):Notification.Builder{
        return Notification.Builder(applicationContext,Second_chaNNel)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.k1)
            .setAutoCancel(true)

    }

    fun getNotification3(title:String,body:String):Notification.Builder{
        return Notification.Builder(applicationContext, therd_chaNNel)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.k1)
            .setAutoCancel(true)

    }

    fun Notify(id:Int,notification: Notification.Builder){
        manager.notify(id,notification.build())
    }

    companion object{
        val first_chaNNel="first"
        val Second_chaNNel="Second"
        val therd_chaNNel="therd"

    }

}