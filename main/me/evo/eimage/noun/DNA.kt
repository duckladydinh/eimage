package me.evo.eimage.noun

import me.evo.eimage.Setting
import java.awt.image.BufferedImage

class DNA: ArrayList<Gen>() {
    fun snapshot() = BufferedImage(Setting.WEIT, Setting.HOCH, BufferedImage.TYPE_4BYTE_ABGR).apply {
        val painter = createGraphics()
        forEach {
            it.draw(painter)
        }
        painter.dispose()
    }
}