package me.evo.eimage.noun

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Rectangle

class Rect: Gen() {
    override fun draw(painter: Graphics2D) {
        painter.paint = Color(this[0], this[1], this[2], this[3])
        painter.fill(
                Rectangle(this[4], this[5], this[6], this[7])
        )
    }
}