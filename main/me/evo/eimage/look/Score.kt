package me.evo.eimage.look

import me.evo.eimage.noun.DNA
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte

abstract class Score(targetImage: BufferedImage) {
    val target = (targetImage.raster.dataBuffer as DataBufferByte).data!!
    fun uIntOf(byte: Byte) = byte.toInt() and 255
    abstract fun measure(dna: DNA): Double
}

