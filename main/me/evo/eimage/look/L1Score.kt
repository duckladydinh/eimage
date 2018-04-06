package me.evo.eimage.look

import me.evo.eimage.noun.DNA
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import kotlin.math.abs

class L1Score(targetImage: BufferedImage): Score(targetImage) {
    override fun measure(dna: DNA): Double {
        val current = (dna.snapshot().raster.dataBuffer as DataBufferByte).data
        var res = 0
        (0 until target.size).forEach {
            res += abs(uIntOf(target[it]) - uIntOf(current[it]))
        }
        return res.toDouble() / target.size
    }
}