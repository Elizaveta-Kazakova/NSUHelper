package ru.nsuhelper.client.factory

import ru.nsuhelper.controller.ControllerClient

class Subject : WorkerTypeCommand() {
    private var subject: String = ""
    private var course: String = ""
    private var url: String = ""

    init {
        setCommand(Constants().SUBJECT)
    }

    fun setUrl(url : String) {
        this.url = url
    }

    fun getUrl() : String {
        return url
    }

    fun setSubject(sub: String) {
        this.subject = sub
    }

    fun setCourse(cr : String) {
        this.course = cr
    }

    override fun outInWindow(controller: ControllerClient) {
        controller.showResponse(url)
    }
}