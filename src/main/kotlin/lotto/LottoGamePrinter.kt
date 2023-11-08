package lotto

class LottoGamePrinter {
    fun showLottoList(lottoCount: Int, lottoList: List<Lotto>) {
        println(LottoGameMessage.LOTTO_NUMBER.format(lottoCount))
        lottoList.forEach { lotto -> println(lotto.lottoNumberToString()) }
    }

    fun showWinningRate(winningMatchedCount: WinningMatchedCount) {
        println(LottoGameMessage.WINNING_RESULT)
        println(LottoGameMessage.THREE_MATCHED.format(winningMatchedCount.threeMatchedCount))
        println(LottoGameMessage.FOUR_MATCHED.format(winningMatchedCount.fourMatchedCount))
        println(LottoGameMessage.FIVE_MATCHED.format(winningMatchedCount.fiveMatchedCount))
        println(LottoGameMessage.FIVE_BONUS_MATCHED.format(winningMatchedCount.fiveAndBonusMatchedCount))
        println(LottoGameMessage.SIX_MATCHED.format(winningMatchedCount.sixMatchedCount))
    }
}