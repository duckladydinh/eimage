package me.evo.eimage.verb

import me.evo.eimage.Rand
import me.evo.eimage.noun.DNA

object GAMutate: Mutate {
    var logs = ArrayList<IntArray>()

    override fun change(dna: DNA) {
        logs.clear()

        var whichGen = -1
        while (true) {
            whichGen += Rand.randInt(dna.size) + 1
            if (whichGen >= dna.size) break

            var whichPos = -1
            while (true) {
                whichPos += Rand.randInt(dna[whichGen].size) + 1
                if (whichPos >= dna[whichGen].size) break
                logs.add(intArrayOf(whichGen, whichPos, dna[whichGen][whichPos]))
                mutate(dna, whichGen, whichPos)
            }
        }
    }

    override fun revert(dna: DNA) {
        while (logs.isNotEmpty()) {
            val log = logs.last()
            logs.removeAt(logs.lastIndex)
            dna[log[0]][log[1]] = log[2]
        }
    }
}