package me.evo.eimage.verb

import me.evo.eimage.Rand.clamp
import me.evo.eimage.Rand.randDouble
import me.evo.eimage.Rand.randInt
import me.evo.eimage.Setting
import me.evo.eimage.noun.DNA

interface Mutate {
    fun mutatedOf(n: Int, L: Int): Int {
        val amt = randInt(L / 10) + 1
        if (randDouble() < 1.0/3) {
            return clamp(n - amt, 0 , L)
        }
        if (randDouble() < 2.0/3) {
            return clamp(n + amt, 0 , L)
        }
        return randInt(L + 1)
    }

    fun getBound(pos: Int) = when {
        pos < 4 -> 255
        pos % 2 == 0 -> Setting.WEIT
        pos % 2 == 1 -> Setting.HOCH
        else -> 0
    }

    fun mutate(dna: DNA, whichGen: Int, whichPos: Int) {
        dna[whichGen][whichPos] = mutatedOf(dna[whichGen][whichPos], getBound(whichPos))
    }

    fun change(dna: DNA)
    fun revert(dna: DNA)
}



