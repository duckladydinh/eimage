package me.evo.eimage

import me.evo.eimage.noun.*
import java.util.SplittableRandom

object Rand {
    val core = SplittableRandom()
    fun randInt(L: Int) = core.nextInt(L)
    fun randDouble() = core.nextDouble()
    fun <T: Comparable<T>> clamp(value: T, L: T, R: T) = when {
        value < L -> L
        value > R -> R
        else -> value
    }

    fun randPoly(n: Int) = Poly().apply {
        (0 until 4).forEach {
            add(randInt(256))
        }
        (0 until n).forEach {
            add(randInt(Setting.WEIT))
            add(randInt(Setting.HOCH))
        }
    }
    fun randPoly() = randPoly(Setting.POLY)

    fun randOval() = Oval().apply {
        (0 until 4).forEach {
            add(randInt(256))
        }
        (0 until 4).forEach {
            add(randInt(Setting.WEIT))
            add(randInt(Setting.HOCH))
        }
    }
    fun randRect() = Rect().apply {
        (0 until 4).forEach {
            add(randInt(256))
        }
        (0 until 4).forEach {
            add(randInt(Setting.WEIT))
            add(randInt(Setting.HOCH))
        }
    }
    fun randGen(): Gen {
        val p = randDouble()
        if (p < 1.0/3) {
            return randPoly()
        }
        if (p < 2.0/3) {
            return randOval()
        }
        return randRect()
    }
    fun randDNA(n: Int = Setting.NUM, gen: () -> Gen = ::randGen) = DNA().apply {
        (0 until n).forEach {
            add(gen())
        }
    }
}