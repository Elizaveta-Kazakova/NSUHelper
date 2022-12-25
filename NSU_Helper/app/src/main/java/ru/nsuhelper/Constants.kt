package ru.nsuhelper

import ru.nsuhelper.controller.CourseSelectionController
import ru.nsuhelper.controller.MaterialsController

class Constants {
    val COURSE_SELECTION_ID = 1
    val MATERIALS_ID = 2
    val PAGE_ID = "PAGE_ID"
    val COURSE_ID = "COURSE_ID"

    val ID_CONTROLLER_MAP = mutableMapOf(
        COURSE_SELECTION_ID to CourseSelectionController::class.java,
        MATERIALS_ID to MaterialsController::class.java)

    val SUBJECTS_MAP = mutableMapOf(
        1 to arrayListOf("Математический анализ", "Математическая логика", "Алгебра и геометрия"),
        2 to arrayListOf("Дгма", "Дискретная математика", "Лоп", "Теория вероятности", "Тфкп"),
        3 to arrayListOf("Вычислительная математика", "Теория Кодирования")
    )
}