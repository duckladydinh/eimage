package me.evo.eimage.noun

import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D

class Oval: Gen() {
    override fun draw(painter: Graphics2D) {
        painter.paint = Color(this[0], this[1], this[2], this[3])
        painter.fill(
                Ellipse2D.Double(this[4].toDouble(), this[5].toDouble(), this[6].toDouble(), this[7].toDouble())
        )
    }
}