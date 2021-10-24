package com.mahmoud.ticktacktoy


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.view.*

import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buClick(view: View) {  //Shake the funkchen that is called from all buttons

        val buSelected = view as Button   //Convert the view to a button

        var cellId = 0  //We define var and give it the value of buttons
        when (buSelected.id) {  //We knock the button and double the id if it is for example 4 Press the 4 button
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        Log.d("cellId:",cellId.toString())//To print the variable value
        playgame(cellId,buSelected)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activeplayer=1
    fun playgame(cellId:Int,buSelected:Button){
        if(activeplayer==1){
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.b)//To change the button color when pressed
            player1.add(cellId)
            activeplayer=2
            autoplay()
        }else{
            buSelected.text="Y"
            buSelected.setBackgroundResource(R.color.darckgreen)//To change the button color when pressed
            player2.add(cellId)
            activeplayer=1
        }
        buSelected.isEnabled=false
        chickwinner()
    }

    fun chickwinner(){
        var  winner=-1  //To see who won the game
        //row1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2
        }
        //row2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2
        }
        //row3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2
        }

        //col1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2
        }
        //col2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2
        }
        //col3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2
        }
        ///////
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2
        }
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2
        }

        if (winner!=-1){
            if (winner==1){
                Toast.makeText(this,"Player 1 Winner The Game",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Player 2 Winner The Game",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun autoplay(){
        //scan empty
        val emptyscells= ArrayList<Int>()//To see the empty naps
        for (cellId in 1..9){
            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyscells.add(cellId)
            }
        }
        //select rand index
        val r=Random()
        val randindex=r.nextInt(emptyscells.size-0)+0
        val cellId=emptyscells[randindex]
        var buselect:Button?
        //inter index to button
        when(cellId){
            1->buselect=bu1
            2->buselect=bu2
            3->buselect=bu3
            4->buselect=bu4
            5->buselect=bu5
            6->buselect=bu6
            7->buselect=bu7
            8->buselect=bu8
            9->buselect=bu9
            else->{
                buselect=bu1
            }
        }
        playgame(cellId,buselect)
    }
}
