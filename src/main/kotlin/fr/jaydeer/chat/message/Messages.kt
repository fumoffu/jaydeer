package fr.jaydeer.chat.message

interface Message

data class TextMessage(val content: String) : Message