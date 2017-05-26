package fr.jaydeer.chat.message

interface ChatMessage

data class TextMessage(val content: String) : ChatMessage