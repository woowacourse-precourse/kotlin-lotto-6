package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    // start 파라미터에 player 추가 예정
    fun start() {
        val money = getPurchaseMoney()
        val player = Player(money)
        printPurchaseLottoQuantity(money.value / 1000)
        val playerLotto = purchaseLotto(player)
        val winningLotto = getWinningLotto()
        val bonusNumber = getBonusNumber()
        val playerLottoRank = getLottoRank(winningLotto, playerLotto, bonusNumber)
        printWinningRank(playerLottoRank)
    }

    private fun getPurchaseMoney(): Money {
        outputView.printAskPurchaseMoney()
        val money = inputView.inputMoney()
        return Money(money)
    }

    private fun printPurchaseLottoQuantity(quantity: Int) {
        outputView.printPurchaseLottoQuantity(quantity)
    }

    private fun getBonusNumber(): LottoNumber {
        outputView.printAskBonusNumber()
        val number = inputView.inputBonusNumber()
        return LottoNumber(number)
    }

    private fun purchaseLotto(player: Player): List<Lotto> {
        val playerLotto = player.purchaseLotto()
        printPlayerLotto(playerLotto)
        return playerLotto
    }

    private fun printPlayerLotto(lotto: List<Lotto>) {
        outputView.printLotto(lotto)
    }

    private fun getWinningLotto(): WinningLotto {
        outputView.printAskWinningNumber()
        val winningNumbers = inputView.inputWinningNumbers().map { LottoNumber(it) }
        return WinningLotto(winningNumbers)
    }

    private fun getLottoRank(winningLotto: WinningLotto, playerLotto: List<Lotto>, bonusNumber: LottoNumber): Map<WinningRank, Int> {
        val lottoRanks = mutableMapOf(
            WinningRank.NO_MATCHES to 0,
            WinningRank.THREE_MATCHES to 0,
            WinningRank.FOUR_MATCHES to 0,
            WinningRank.FIVE_MATCHES to 0,
            WinningRank.FIVE_MATCHES_WITH_BONUS_NUMBER to 0,
            WinningRank.SIX_MATCHES to 0
        )

        playerLotto.forEach { lotto ->
            val rank = winningLotto.determineWinner(lotto, bonusNumber.number)
            lottoRanks[rank] = lottoRanks[rank]!! + 1
        }

        return lottoRanks
    }

    private fun printWinningRank(rank: Map<WinningRank, Int>) {
        outputView.printRank(rank)
    }

}