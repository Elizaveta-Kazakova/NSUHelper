package ru.nsuhelper.controller

import android.content.AsyncQueryHandler
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.nsuhelper.R
import java.net.Socket


class CourseSelectionController : AppCompatActivity(), ControllerClient {
    private val FIRST_COURSE : Int = 1
    private val SECOND_COURSE : Int = 2
    private val THIRD_COURSE : Int = 3
    private val FOURTH_COURSE : Int = 4
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


    }

    fun showFeedback(view : View) {
        val intent = Intent(this, FeedbackController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().PAGE_ID, ru.nsuhelper.Constants().COURSE_SELECTION_ID)
        startActivity(intent)
    }

    fun showFirstCourseMaterials(view : View) {
        println("select first course")
        val intent = Intent(this, MaterialsController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().COURSE_ID, FIRST_COURSE.toString())
        println(intent.getStringExtra("course in selection course" + ru.nsuhelper.Constants().COURSE_ID))
        startActivity(intent)
    }

    fun showSecondCourseMaterials(view : View) {
        println("select first course")
        val intent = Intent(this, MaterialsController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().COURSE_ID, SECOND_COURSE.toString())
        println(intent.getStringExtra("course in selection course" + ru.nsuhelper.Constants().COURSE_ID))
        startActivity(intent)
    }

    fun showThirdCourseMaterials(view : View) {
        println("select first course")
        val intent = Intent(this, MaterialsController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().COURSE_ID, THIRD_COURSE.toString())
        println(intent.getStringExtra("course in selection course" + ru.nsuhelper.Constants().COURSE_ID))
        startActivity(intent)
    }

    fun showFourthCourseMaterials(view : View) {
        println("select first course")
        val intent = Intent(this, MaterialsController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().COURSE_ID, FOURTH_COURSE.toString())
        println(intent.getStringExtra("course in selection course" + ru.nsuhelper.Constants().COURSE_ID))
        startActivity(intent)
    }

    override fun showResponse(response: String) {

    }

    override fun showResponse(response: ArrayList<String>) {

    }

}