package lotto

object Printer {
    fun print(message: Message) {
        println(message)
    }

    fun error(message: Message) {
        error(message.toString())
    }

    fun error(message: String) {
        println(Message.ErrorPrefix.toString() + message)
    }
}
