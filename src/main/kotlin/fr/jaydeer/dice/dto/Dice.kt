package fr.jaydeer.dice.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import fr.jaydeer.common.api.validation.NoneId
import fr.jaydeer.common.api.validation.groups.Creation
import fr.jaydeer.common.dto.EntityDto
import fr.jaydeer.dice.entity.DiceEntity
import javax.validation.constraints.NotNull

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type",
        visible = false, defaultImpl = CustomDice::class)
@JsonSubTypes(
        Type(value = NSideDice::class, name = DiceType.Id.N_SIDE),
        Type(value = CustomDice::class, name = DiceType.Id.CUSTOM)
)
sealed class Dice

data class NSideDice(val n: Int,
                     val start: Int = 1,
                     val step: Int = 1) : Dice()

data class CustomDice(@get:NoneId(value = DiceEntity::class, groups = arrayOf(Creation::class))
                      override val id: String?,
                      @NotNull(groups = arrayOf(Creation::class))
                      val faces: Map<String, Int>?) : EntityDto, Dice()