package me.evo.eimage.plan

import me.evo.eimage.look.Score
import me.evo.eimage.noun.DNA
import me.evo.eimage.verb.Mutate
import me.ui.preview.PImageMonitor

class BestSelector(dna: DNA, mutate: Mutate, score: Score, monitor: PImageMonitor? = null): Selector(dna, mutate, score, monitor) {
    override fun evolve(n: Int): DNA {
        var curFitness = score.measure(dna)

        (1 .. n).forEach {
            mutate.change(dna)
            val newFitness = score.measure(dna)

            if (newFitness < curFitness) { // better
                curFitness = newFitness

                // reporting
                if (monitor != null) {
                    monitor.show(dna.snapshot())
                }
                println("Generation\t$it:\t$curFitness")
            } else { // worse
                mutate.revert(dna)
            }
        }

        return dna
    }
}