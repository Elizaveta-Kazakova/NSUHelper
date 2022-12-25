package ru.nsuhelper.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import ru.nsuhelper.R

class FeedbackController : AppCompatActivity() {
    private lateinit  var feedbackField : EditText
    private lateinit  var sendButton : Button
    private lateinit  var goBackButton : Button

    private  var idOfPreviousPage : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback)

        idOfPreviousPage = intent.getStringExtra(ru.nsuhelper.Constants().PAGE_ID)?.toInt()

        feedbackField = findViewById(R.id.feedback_field)
        sendButton = findViewById(R.id.send_button)
        goBackButton = findViewById(R.id.go_back_button)
    }

    fun goBack(view : View) {
        intent = Intent(this, ru.nsuhelper.Constants().ID_CONTROLLER_MAP.get(idOfPreviousPage))
        startActivity(intent)
    }
}