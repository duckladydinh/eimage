package me.evo.eimage.noun

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Polygon

class Poly: Gen() {
    override fun draw(painter: Graphics2D) {
        painter.paint = Color(this[0], this[1], this[2], this[3])
        painter.fill(
                Polygon().apply {
                    (4 until size step 2).forEach {
                        addPoint(get(it), get(it+1))
                    }
                }
        )
    }
}