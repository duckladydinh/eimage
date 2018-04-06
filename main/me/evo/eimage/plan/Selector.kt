package me.evo.eimage.plan

import me.evo.eimage.look.Score
import me.evo.eimage.verb.Mutate
import me.evo.eimage.noun.DNA
import me.ui.preview.PImageMonitor

abstract class Selector(val dna: DNA, val mutate: Mutate, val score: Score, val monitor: PImageMonitor? = null) {
    abstract fun evolve(n: Int): DNA
}

