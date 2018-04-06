package me.ui.preview

import javafx.stage.Stage
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch

open class PMonitor {
    lateinit var stage: Stage
    lateinit var job: Job

    open fun turnOn(w: Int, h: Int) {
        job = launch (JavaFx) {
            stage = Stage().apply {
                width = w.toDouble()
                height = h.toDouble()
            }
            stage.show()
            stage.centerOnScreen()
        }
    }

    open fun holdOn() = launch {
        job.join()
    }

}