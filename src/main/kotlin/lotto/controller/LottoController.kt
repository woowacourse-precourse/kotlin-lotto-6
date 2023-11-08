package lotto.controller

import lotto.domain.*
import lotto.utils.Constant.LOTTO_PRICE
import lotto.view.InputView
import lotto.view.OutputView

private const val DEFAULT_COUNT = 0
private const val MATCH_LOTTO = 1

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    private val lottoRanks = mutableMapOf(
        WinningRank.NO_MATCHES to DEFAULT_COUNT,
        WinningRank.THREE_MATCHES to DEFAULT_COUNT,
        WinningRank.FOUR_MATCHES to DEFAULT_COUNT,
        WinningRank.FIVE_MATCHES to DEFAULT_COUNT,
        WinningRank.FIVE_MATCHES_WITH_BONUS_NUMBER to DEFAULT_COUNT,
        WinningRank.SIX_MATCHES to DEFAULT_COUNT
    )

    fun start() {
        val money = getPurchaseMoney()
        val player = Player(money)
        val purchaseQuantity = money.value.div(LOTTO_PRICE)
        printPurchaseLottoQuantity(purchaseQuantity)
        val playerLotto = purchaseLotto(player)

        val (winningLotto, bonusNumber) = getWinningLottoAndBonusNumber()
        val playerLottoRank = getLottoRank(winningLotto, playerLotto, bonusNumber)
        printWinningRank(playerLottoRank)
        val revenue = calculateRevenue(player, playerLottoRank)
        printRevenue(revenue)
    }

    private fun getPurchaseMoney(): Money {
        outputView.printAskPurchaseMoney()
        return inputView.inputMoney()
    }

    private fun printPurchaseLottoQuantity(quantity: Int) {
        outputView.printPurchaseLottoQuantity(quantity)
    }

    private fun purchaseLotto(player: Player): List<Lotto> {
        val playerLotto = player.purchaseLotto()
        printPlayerLotto(playerLotto)
        return playerLotto
    }

    private fun printPlayerLotto(lotto: List<Lotto>) {
        outputView.printLotto(lotto)
    }

    private fun getWinningLottoAndBonusNumber(): Pair<WinningLotto, LottoNumber> {
        return inputView.inputWinningNumbersWithBonusNumber()
    }

    private fun getLottoRank(
        winningLotto: WinningLotto,
        playerLotto: List<Lotto>,
        bonusNumber: LottoNumber
    ): Map<WinningRank, Int> {

        playerLotto.forEach { lotto ->
            val rank = winningLotto.determineWinner(lotto, bonusNumber.number)
            lottoRanks[rank] = lottoRanks[rank]!! + MATCH_LOTTO
        }

        return lottoRanks
    }

    private fun printWinningRank(rank: Map<WinningRank, Int>) {
        outputView.printRank(rank)
    }

    private fun calculateRevenue(player: Player, rank: Map<WinningRank, Int>): Double {
        val revenue = player.calculateRevenue(rank)
        return revenue
    }

    private fun printRevenue(revenue: Double) {
        outputView.printRevenue(revenue)
    }


}