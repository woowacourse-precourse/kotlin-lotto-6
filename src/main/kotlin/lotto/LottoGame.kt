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
        val (numOfLotto, lottoTickets) = generateLottoTickets(price)
        gameConsole.showLottoTickets(lottoTickets, numOfLotto)

        val winningResult = determineWiningResult(lottoTickets)
        gameConsole.showWinningStatistic(winningResult)
        gameConsole.showEarningRate(lottoResultChecker.calculateEarningRate(price))
    }

    fun generateLottoTickets(price: Int): Pair<Int, List<Lotto>> {
        val numOfLotto = lottoMachine.calculateNumberOfLotto(price)
        val lottoTickets = lottoMachine.getLottoTickets(numOfLotto)

        return Pair(numOfLotto, lottoTickets)
    }

    private fun determineWiningResult(lottoTickets: List<Lotto>): Map<WinningCriteria, Int> {
        val winningNumbers = userInputReader.getWinningNumbers()
        val bonusNum = userInputReader.getBonusNumber(winningNumbers)

        return lottoResultChecker.compareLottoTicketsWithWinningNumbers(lottoTickets, winningNumbers, bonusNum)
    }
}