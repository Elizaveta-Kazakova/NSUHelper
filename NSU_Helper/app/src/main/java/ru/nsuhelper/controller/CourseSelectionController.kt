package ru.nsuhelper.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.nsuhelper.R
import java.net.Socket


class CourseSelectionController : AppCompatActivity() {
    private val ip  = "192.168.0.110"
    private val port = 8080
    private lateinit var firstCourseButton : Button
    private lateinit var secondCourseButton : Button
    private lateinit var thirdCourseButton : Button
    private lateinit var fourthCourseButton : Button
    private lateinit var feedbackButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_selection)

        firstCourseButton = findViewById(R.id.first_course_button)
        secondCourseButton = findViewById(R.id.second_course_button)
        thirdCourseButton = findViewById(R.id.third_course_button)
        fourthCourseButton = findViewById(R.id.fourth_course_button)
        feedbackButton = findViewById(R.id.feedback_button)

//        val client = Socket(ip, port)
    }

    fun showFeedback(view : View) {
        val intent = Intent(this, FeedbackController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().PAGE_ID, ru.nsuhelper.Constants().COURSE_SELECTION_ID)
        startActivity(intent)
    }

    fun showFirstCourseMaterials(view : View) {
        val intent = Intent(this, MaterialsController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().COURSE_ID, 1)
        startActivity(intent)
    }

}