package me.evo.eimage.verb

import me.evo.eimage.Rand
import me.evo.eimage.noun.DNA

object HCMutate: Mutate {
    var log = IntArray(0)

    override fun change(dna: DNA) {
        val whichGen = Rand.randInt(dna.size)
        val whichPos = Rand.randInt(dna[whichGen].size)
        log = intArrayOf(whichGen, whichPos, dna[whichGen][whichPos])
        mutate(dna, whichGen, whichPos)
    }

    override fun revert(dna: DNA) {
        dna[log[0]][log[1]] = log[2]
    }
}