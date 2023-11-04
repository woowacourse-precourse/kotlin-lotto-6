package lotto

object Printer {
    fun println() {
        kotlin.io.println()
    }

    fun print(message: Message) {
        println(message)
    }

    fun print(purchase: Purchase) {
        val lottos = purchase.lottos
        val purchasedMessage = Message.Purchased.toString()
        println()
        println(purchasedMessage.format(lottos.size))
        lottos.forEach { println(it) }
        println()
    }

    fun error(message: Message) {
        error(message.toString())
    }

    fun error(message: String) {
        println(Message.ErrorPrefix.toString() + message)
    }
}
