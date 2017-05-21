package fr.jaydeer.chat.message

sealed class Message

data internal class TextMessage(val content: String) : Message()