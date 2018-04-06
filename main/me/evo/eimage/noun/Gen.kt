package me.evo.eimage.noun

import java.awt.Graphics2D

abstract class Gen: ArrayList<Int>() {
    abstract fun draw(painter: Graphics2D)
}
