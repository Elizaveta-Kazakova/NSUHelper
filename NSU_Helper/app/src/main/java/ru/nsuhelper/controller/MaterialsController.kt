package ru.nsuhelper.controller

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.nsuhelper.R
import ru.nsuhelper.client.WorkerWithServer
import java.net.Socket

class MaterialsController : AppCompatActivity(), ControllerClient {
    private val ip : String = "172.20.10.2"
    private val port : Int = 8080
    private lateinit var goBackButton : Button
    private lateinit var feedbackButton : Button
    private lateinit var materialsView : LinearLayout
    private lateinit var worker : WorkerWithServer
    private var courseID : Int? = null
    private lateinit var thread : Thread

    private fun getTableName(courseID: Int?) : String{
        return when (courseID) {
            1 -> "nsu.1course"
            2 -> "nsu.2course"
            3 -> "nsu.3course"
            4 -> "nsu.4course"
            else -> ""
        }
    }

    private fun fillSubjects(text : ArrayList<String>?) {
        for (subjectName in text!!) {
            val text = TextView(this)
            text.setText(subjectName)
            text.textSize = 30f

            val subjectButton = Button(this)
//            subjectButton.backgroundTintMode = "#2A6577" as Mode
            subjectButton.setOnClickListener(View.OnClickListener {
                DoAsync {
                    worker.sendMessageSelect(subjectName, getTableName(courseID))
                }.execute()
                /*val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(browserIntent) */})

            materialsView.addView(text as View)
            materialsView.addView(subjectButton as View)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.materials)

        goBackButton = findViewById(R.id.go_back_button)
        feedbackButton = findViewById(R.id.feedback_button)

        courseID = intent.getStringExtra(ru.nsuhelper.Constants().COURSE_ID)?.toInt()
        println("course id = $courseID")

        materialsView = findViewById(R.id.materials_view)

//        DoAsync {
//            var client = Socket(ip, port)
//            worker = WorkerWithServer(client)
////            worker.sendMessageSelect("Математический анализ", "nsu.1course")
//        }.execute()

        thread = Thread {
            var client = Socket(ip, port)
            worker = WorkerWithServer(client, this)
//            worker.sendMessageSelect("Математический анализ", "nsu.1course")
        }.apply { start() }


        fillSubjects(ru.nsuhelper.Constants().SUBJECTS_MAP[courseID])
//        text.text = getFormattedText(ru.nsuhelper.Constants().SUBJECTS_MAP[courseID])


    }

    fun showFeedback(view : View) {
        intent = Intent(this, FeedbackController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().PAGE_ID, ru.nsuhelper.Constants().MATERIALS_ID)
        startActivity(intent)
    }

    fun goBack(view : View) {
        startActivity(Intent(this, CourseSelectionController::class.java))
    }

    fun goToMaterial(url : String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    fun getCourseId() : Int? {
        return courseID
    }

    override fun showResponse(response: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(response))
        startActivity(browserIntent)
    }

    override fun showResponse(response: ArrayList<String>) {

    }
}