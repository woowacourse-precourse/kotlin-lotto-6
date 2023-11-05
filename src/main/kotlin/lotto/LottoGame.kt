package lotto

import ui.GameConsole
import ui.UserInputReader

class LottoGame(
    private val userInputReader: UserInputReader,
    private val lottoMachine: LottoMachine,
    private val gameConsole: GameConsole,
    private val lottoResultChecker: LottoResultChecker
) {
    fun startGame() {
        val price = userInputReader.getPrice()
        val lottoTickets = generateLottoTickets(price)

        determineWiningResult(lottoTickets)
        gameConsole.showEarningRate(lottoResultChecker.calculateEarningRate(price))
    }

    private fun generateLottoTickets(price: Int): List<Lotto> {
        val numOfLotto = lottoMachine.calculateNumberOfLotto(price)
        val lottoTickets = lottoMachine.getLottoTickets(numOfLotto)

        gameConsole.showLottoTickets(lottoTickets, numOfLotto)
        return lottoTickets
    }

    private fun determineWiningResult(lottoTickets: List<Lotto>) {
        val winningNumbers = userInputReader.getWinningNumbers()
        val bonusNum = userInputReader.getBonusNumber(winningNumbers)
        val winningResult = lottoResultChecker.compareLottoTicketsWithWinningNumbers(lottoTickets, winningNumbers, bonusNum)

        gameConsole.showWinningStatistic(winningResult)
    }
}