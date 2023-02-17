package ru.nsuhelper.client.factory

import ru.nsuhelper.controller.ControllerClient


interface TypeCommand {
    fun outInWindow(controller : ControllerClient)
}