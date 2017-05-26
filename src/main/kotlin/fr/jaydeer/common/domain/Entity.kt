package fr.jaydeer.common.domain

interface Entity<out ID: Entity.Id> {
    val id: ID

    interface Id
}