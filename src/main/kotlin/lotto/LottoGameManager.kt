package lotto

import lotto.model.Lotto
import lotto.model.LottoGame
import lotto.model.LottoWinningNumbers
import lotto.utils.LottoPublisher

class LottoGameManager {
    private lateinit var lottoGame: LottoGame
    private var lottoInputHandler: LottoInputHandler
    private var lottoPublisher: LottoPublisher

    init {
        lottoInputHandler = LottoInputHandler()
        lottoPublisher = LottoPublisher()
    }

    fun startLottoGame() {
        val lottoTickets = publishLottoTickets()
        val lottoWinningNumbers = setWinningNumbers()

        lottoGame = LottoGame(lottoTickets, lottoWinningNumbers)

        lottoGame.matchLottoNumbers()
    }

    private fun publishLottoTickets(): List<Lotto> {
        println("구입금액을 입력해 주세요.")
        val lottoTicketsAmount = receiveLottoTicketsAmount()
        return lottoPublisher.publishLottoTickets(lottoTicketsAmount)
    }

    private fun setWinningNumbers(): LottoWinningNumbers {
        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = receiveWinningNumbers()

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = receiveBonusNumber(winningNumbers)

        return LottoWinningNumbers(winningNumbers, bonusNumber)
    }

    private fun printLottoGameResult() {
        lottoGame.matchLottoNumbers()
    }

    private fun receiveLottoTicketsAmount(): Int = lottoInputHandler.receiveLottoCost() / 1000

    private fun receiveWinningNumbers(): List<Int> = lottoInputHandler.receiveLottoWinningNumbers()

    private fun receiveBonusNumber(winningNumbers: List<Int>): Int =
        lottoInputHandler.receiveLottoBonusNumber(winningNumbers)
}