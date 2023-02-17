package ru.nsuhelper.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.nsuhelper.R
import ru.nsuhelper.client.WorkerWithServer
import java.net.Socket

class FeedbackController : AppCompatActivity(), ControllerClient {
    private val ip : String = "172.20.10.2"
    private val port : Int = 8080
    private lateinit  var feedbackField : EditText
    private lateinit  var sendButton : Button
    private lateinit  var goBackButton : Button
    private lateinit var feedbacks : LinearLayout
    private lateinit var thread : Thread
    private lateinit var worker : WorkerWithServer

    private  var idOfPreviousPage : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback)

        idOfPreviousPage = intent.getStringExtra(ru.nsuhelper.Constants().PAGE_ID)?.toInt()

        feedbackField = findViewById(R.id.feedback_field)
        sendButton = findViewById(R.id.send_button)
        goBackButton = findViewById(R.id.go_back_button)
        feedbacks = findViewById(R.id.feedbacks)

        thread = Thread {
            var client = Socket(ip, port)
            worker = WorkerWithServer(client, this)
        }.apply { start() }
    }

    fun goBack(view : View) {
        intent = Intent(this, CourseSelectionController::class.java)
        startActivity(intent)
    }

    fun sendFeedback(view : View) {
        DoAsync {
            val feedback = feedbackField.text.toString()
            worker.insertReview(feedback)
        }.execute()
    }

    override fun showResponse(response: String) {
    }

    override fun showResponse(response: ArrayList<String>) {
        runOnUiThread {
            response.forEach{
                var message = TextView(this)
                message.textSize = 30f
                message.text = it
                feedbacks.addView(message as View)
            }
        }

    }
}