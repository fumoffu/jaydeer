package fr.jaydeer.dice.nside

import fr.jaydeer.dice.Dice
import fr.jaydeer.dice.face.IntFace

interface IntDice : Dice {
    val n: Int
    val start: Int
    val step: Int

    override val faces: Map<IntFace, Int>
        get() = hashMapOf(*(1..n).map { (IntFace(it * step + start - 1) to 1) }.toTypedArray())
}