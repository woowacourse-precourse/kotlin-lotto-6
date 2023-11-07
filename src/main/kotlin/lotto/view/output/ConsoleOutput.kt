package lotto.view.output

class ConsoleOutput : OutputInterface {
    override fun printMessage(message: String) {
        println(message)
    }

    override fun print(message: String){
        print(message)
    }
}
