package lotto

import camp.nextstep.edu.missionutils.Randoms
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

        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = receiveWinningNumbers()

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = receiveBonusNumber()
        lottoGame = LottoGame(lottoTickets, winningNumbers, bonusNumber)

        lottoGame.matchLottoNumbers()
    }

    private fun publishLottoTickets() : List<Lotto>{
        println("구입금액을 입력해 주세요.")
        val lottoTicketsAmount = receiveLottoTicketsAmount()
        return lottoPublisher.publishLottoTickets(lottoTicketsAmount)
    }

    private fun matchLottoNumbers(){

    }



    private fun receiveLottoTicketsAmount(): Int = lottoInputHandler.receiveLottoCost() / 1000

    private fun receiveWinningNumbers(): List<Int> = lottoInputHandler.receiveLottoWinningNumbers()

    private fun receiveBonusNumber(): Int = lottoInputHandler.receiveLottoBonusNumber()
}