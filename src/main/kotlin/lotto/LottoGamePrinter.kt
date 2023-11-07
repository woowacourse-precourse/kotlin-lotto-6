package lotto

class LottoGamePrinter {
    fun showLottoList(lottoCount: Int, lottoList: List<Lotto>) {
        println(LottoGameMessage.LOTTO_NUMBER.format(lottoCount))
        lottoList.forEach { lotto -> println(lotto.lottoNumberToString()) }
    }

    fun showWinningRate(winningRate: WinningRate) {
        println(LottoGameMessage.WINNING_RESULT)
        println(LottoGameMessage.THREE_MATCHED.format(winningRate.threeMatchedCount))
        println(LottoGameMessage.FOUR_MATCHED.format(winningRate.fourMatchedCount))
        println(LottoGameMessage.FIVE_MATCHED.format(winningRate.fiveMatchedCount))
        println(LottoGameMessage.FIVE_BONUS_MATCHED.format(winningRate.fiveAndBonusMatchedCount))
        println(LottoGameMessage.SIX_MATCHED.format(winningRate.sixMatchedCount))
    }
}