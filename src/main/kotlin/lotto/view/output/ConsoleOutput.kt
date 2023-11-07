package lotto.view.output

class ConsoleOutput : OutputInterface {
    override fun printMessage(message: String) {
        println(message)
    }
}
