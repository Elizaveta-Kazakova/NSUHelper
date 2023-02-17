package ru.nsuhelper.client.factory

import ru.nsuhelper.controller.ControllerClient


class FeedBack : WorkerTypeCommand() {
    private var feedBack : String = ""
    private var listReviews = ArrayList<String>()

    fun setListReviews(list : ArrayList<String>) {
            listReviews = list
    }

    fun getList() : ArrayList<String> {
        return listReviews
    }

    fun setFeedBack(str : String) {
        this.feedBack = str
    }

    fun getFeedBack() : String {
        return feedBack
    }

    init {
        setCommand(Constants().FEEDBACK)
    }

    override fun outInWindow(controller: ControllerClient) {
        controller.showResponse(listReviews)
    }
}

