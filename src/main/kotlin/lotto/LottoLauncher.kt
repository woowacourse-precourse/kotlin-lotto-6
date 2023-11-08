package lotto

object LottoLauncher {
    fun run() {
        val messagePrinter = ConsolePrinter
        val inputReader = InputReader()
        val lottoMachine = LottoMachine
        val resultCalculator = ResultCalculator()
        val resultPrinter = ResultPrinter(ConsolePrinter)

        val game = LottoGame(messagePrinter, inputReader, lottoMachine, resultCalculator, resultPrinter)
        game.start()
    }
}
