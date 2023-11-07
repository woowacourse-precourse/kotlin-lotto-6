package lotto

import lotto.utils.LottoNumbersGenerator

class LottoGameManager {
    private lateinit var lottoGame: LottoGame
    private var lottoInputHandler: LottoInputHandler

    init {
        lottoInputHandler = LottoInputHandler()
    }

    fun startLottoGame() {
        println("구입금액을 입력해 주세요.")
        val lottoTicketsAmount = receiveLottoTicketsAmount()
        val lottoTickets = publishLottoTickets(lottoTicketsAmount)

        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = receiveWinningNumbers()

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = receiveBonusNumber()
        lottoGame = LottoGame(lottoTickets, winningNumbers, bonusNumber)
    }

    private fun publishLottoTickets(lottoAmount: Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        println("\n${lottoAmount}개를 구매했습니다.")
        repeat(lottoAmount) {
            val lotto = Lotto(LottoNumbersGenerator.generateLottoNumbers())
            lotto.printNumbers()
            lottoTickets.add(lotto)
        }
        return lottoTickets
    }

    private fun receiveLottoTicketsAmount(): Int = lottoInputHandler.receiveLottoCost() / 1000

    private fun receiveWinningNumbers(): List<Int> = lottoInputHandler.receiveLottoWinningNumbers()

    private fun receiveBonusNumber(): Int = lottoInputHandler.receiveLottoBonusNumber()
}