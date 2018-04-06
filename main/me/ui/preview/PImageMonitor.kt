package me.ui.preview

import javafx.embed.swing.SwingFXUtils
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import java.awt.image.BufferedImage

class PImageMonitor: PMonitor() {
    var imageViewer = ImageView()
    override fun turnOn(w: Int, h: Int) {
        super.turnOn(w, h)

        launch (JavaFx) {
            stage.scene = Scene(
                    VBox().apply {
                        alignment = Pos.CENTER
                        children.add(imageViewer)
                    },
                    w.toDouble(),
                    h.toDouble()
            )
//            stage.scene.fill = Color(47.0/255,52.0/255,57.0/255,1.0)
        }
    }

    fun show(img: BufferedImage) {
        imageViewer.image = SwingFXUtils.toFXImage(img, null)
    }

    // url = "file:$path"
    fun show(url: String) = launch(JavaFx) {
        imageViewer.image = Image(url)
    }
}