package com.example.umpirebuddy

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var balls = 0
        var strikes = 0
        var max = false

        fun reset(){
            balls = 0
            strikes = 0
            strikesView.text = "$strikes Strikes"
            ballsView.text = "$balls Balls"
            max = false
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val strikeBuilder = AlertDialog.Builder(this)
        strikeBuilder.setTitle("Out!")
        strikeBuilder.setPositiveButton("Reset") { dialogInterface: DialogInterface, i: Int ->
            reset()
        }

        val ballBuilder = AlertDialog.Builder(this)
        ballBuilder.setTitle("Walk!")
        ballBuilder.setPositiveButton("Reset") { dialogInterface: DialogInterface, i: Int ->
            reset()
        }


        strikesView.text = "$strikes Strikes"
        ballsView.text = "$balls Balls"

        exitBtn.setOnClickListener {
            finish()
        }

        aboutBtn.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }

        strikesInc.setOnClickListener {
            if (!max){
                strikes +=1
                strikesView.text = "$strikes Strikes"
            }

            if (strikes >= 3){
                max = true
                strikeBuilder.show()
            }
        }

        ballsInc.setOnClickListener {
            if(!max){
                balls += 1
                ballsView.text = "$balls Balls"
            }

            if (balls >= 4){
                max = true
                ballBuilder.show()
            }

        }

        resetBtn.setOnClickListener {
            reset()
        }

    }
}
