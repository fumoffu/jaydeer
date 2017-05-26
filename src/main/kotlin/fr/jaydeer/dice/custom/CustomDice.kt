package fr.jaydeer.dice.custom

import fr.jaydeer.dice.Dice
import fr.jaydeer.dice.face.StringFace

interface CustomDice: Dice {
    override val faces: Map<StringFace, Int>
}