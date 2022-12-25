package ru.nsuhelper.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import ru.nsuhelper.R
import ru.nsuhelper.view.MaterialsView

class MaterialsController(/*materials : MaterialsView*/) : AppCompatActivity() {
    private lateinit var goBackButton : Button
    private lateinit var feedbackButton : Button
    private lateinit var materialsView : LinearLayout
    private var courseID : Int? = null

//    fun initMaterials(courseID : Int) {
//        when (courseID) {
//            1 -> table = "nsu.1course"
//            2 -> table = "nsu.2course"
//            3 -> table = "nsu.3course"
//            4 -> table = "nsu.4course"
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.materials)

        goBackButton = findViewById(R.id.go_back_button)
        feedbackButton = findViewById(R.id.feedback_button)

        courseID = intent.getStringExtra(ru.nsuhelper.Constants().COURSE_ID)?.toInt()

        materialsView = findViewById(R.id.materials_view)
    }

    fun showFeedback(view : View) {
        intent = Intent(this, FeedbackController::class.java)
        intent.putExtra(ru.nsuhelper.Constants().PAGE_ID, ru.nsuhelper.Constants().MATERIALS_ID)
        startActivity(intent)
    }

    fun goBack(view : View) {
        startActivity(Intent(this, CourseSelectionController::class.java))
    }

    fun getCourseId() : Int? {
        return courseID
    }
}