package lotto.controller

import lotto.model.LottoGenerator
import lotto.model.LottoResult
import lotto.view.Input
import lotto.view.Output


class LottoController {
    private val input: Input = Input()
    private val output: Output = Output()
    private val lottoResult: LottoResult = LottoResult()
    private val lottoGenerator: LottoGenerator = LottoGenerator()

    fun startGame(){
        val purchasedMoney = getPurchasedMoney()
        val ticketsNum = countTicketsNum(purchasedMoney)

        output.getWinningInfoNotice()
        val winningLottoInfo = input.getwinningLottoInfo()

        output.getBonusInfoNotice()
        val bonusInfo = input.getbonusInfo()

        output.showLottoCount(ticketsNum)
        val lottos = lottoGenerator.getLottos(ticketsNum)
        output.showLottos(lottos)

        val lottoResult = lottoResult.calculateLottoResult(ticketsNum, lottos, winningLottoInfo, bonusInfo)
        output.showResult(lottoResult)
    }

    private fun getPurchasedMoney(): Int {
        output.startGameNotice()
        return input.getPurchasedMoney()
    }

    private fun countTicketsNum(purchasedMoney: Int): Int {
        return purchasedMoney / 1000
    }
}