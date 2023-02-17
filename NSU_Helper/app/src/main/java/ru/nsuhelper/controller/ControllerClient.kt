package ru.nsuhelper.controller

interface ControllerClient {
    fun showResponse(response : String)
    fun showResponse(response : ArrayList<String>)
}