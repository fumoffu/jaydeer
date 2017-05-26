package fr.jaydeer.dice

import fr.jaydeer.dice.face.Face

interface Dice {
    val faces: Map<out Face, Int>
}



