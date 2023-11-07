package lotto

class LottoCalculator {
    fun calLottoCount(purchasedAmount: Int) = purchasedAmount / 1000
    fun calWinningNumberMatchCount(winningList: List<Int>, lottoNumbers: List<Int>) = winningList.count { lottoNumbers.contains(it) }
    fun calBonusNumberMatchCount(bonusNumber: Int, lottoNumbers: List<Int>) = lottoNumbers.count { it == bonusNumber}

    fun calMatchCount(
        lottoList: List<Lotto>,
        winningList: List<Int>,
        bonusNumber: Int
    ): List<MatchedData> {
        val dataList = mutableListOf<MatchedData>()
        lottoList.forEach { lotto ->
            dataList.add(MatchedData(
                calWinningNumberMatchCount(winningList, lotto.getNumbers()),
                calBonusNumberMatchCount(bonusNumber, lotto.getNumbers())
            ))
        }
        return dataList.toList()
    }

    fun calWinningRate(lottoList: List<Lotto>, winningList: List<Int>, bonusNumber: Int): WinningRate {
        val dataList = calMatchCount(lottoList, winningList, bonusNumber)
        val winningRate = WinningRate()
        dataList.forEach {
            when {
                it.winningMatchCount == 3 && it.bonusNumber == 0 -> winningRate.threeMatchedCount += 1
                it.winningMatchCount == 4 && it.bonusNumber == 0 -> winningRate.fourMatchedCount += 1
                it.winningMatchCount == 5 && it.bonusNumber == 0 -> winningRate.fiveMatchedCount += 1
                it.winningMatchCount == 5 && it.bonusNumber == 1 -> winningRate.fiveAndBonusMatchedCount += 1
                it.winningMatchCount == 6 && it.bonusNumber == 0 -> winningRate.sixMatchedCount += 1
            }
        }
        return winningRate
    }

    fun showWinningRate(winningRate: WinningRate) {
        println(LottoGameMessage.WINNING_RESULT)
        println(LottoGameMessage.THREE_MATCHED.format(winningRate.threeMatchedCount))
        println(LottoGameMessage.FOUR_MATCHED.format(winningRate.fourMatchedCount))
        println(LottoGameMessage.FIVE_MATCHED.format(winningRate.fiveMatchedCount))
        println(LottoGameMessage.FIVE_BONUS_MATCHED.format(winningRate.fiveAndBonusMatchedCount))
        println(LottoGameMessage.SIX_MATCHED.format(winningRate.sixMatchedCount))
    }

    fun calProfitRate(winningRate: WinningRate, purchasedAmount: Int): Double {
        var sum : Long = 0;
        sum += LottoPrice.THREE_MATCHED.calculatePrice(winningRate.threeMatchedCount)
        sum += LottoPrice.FOUR_MATCHED.calculatePrice(winningRate.fourMatchedCount)
        sum += LottoPrice.FIVE_MATCHED.calculatePrice(winningRate.fiveMatchedCount)
        sum += LottoPrice.FIVE_BONUS_MATCHED.calculatePrice(winningRate.fiveAndBonusMatchedCount)
        sum += LottoPrice.SIX_MATCHED.calculatePrice(winningRate.sixMatchedCount)
        return "%.2f".format(sum.toDouble() / purchasedAmount.toDouble() * 100).toDouble()
    }
}