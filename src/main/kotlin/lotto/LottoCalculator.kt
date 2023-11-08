package lotto

class LottoCalculator {
    fun calLottoCount(purchasedAmount: Int) = purchasedAmount / 1000
    fun calWinningNumberMatchCount(winningList: List<Int>, lottoNumbers: List<Int>) = winningList.count { lottoNumbers.contains(it) }
    fun calBonusNumberMatchCount(bonusNumber: Int, lottoNumbers: List<Int>) = lottoNumbers.count { it == bonusNumber }

    fun calMatchCount(lottoList: List<Lotto>, winningList: List<Int>, bonusNumber: Int): List<MatchedData> {
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
                it.winningNumberMatchedCount == 3 && it.bonusNumberMatchedCount == 0 -> winningRate.threeMatchedCount += 1
                it.winningNumberMatchedCount == 4 && it.bonusNumberMatchedCount == 0 -> winningRate.fourMatchedCount += 1
                it.winningNumberMatchedCount == 5 && it.bonusNumberMatchedCount == 0 -> winningRate.fiveMatchedCount += 1
                it.winningNumberMatchedCount == 5 && it.bonusNumberMatchedCount == 1 -> winningRate.fiveAndBonusMatchedCount += 1
                it.winningNumberMatchedCount == 6 && it.bonusNumberMatchedCount == 0 -> winningRate.sixMatchedCount += 1
            }
        }
        return winningRate
    }

    fun calProfitRate(winningRate: WinningRate, purchasedAmount: Int): Double {
        var sum: Long = 0;
        sum += LottoPrice.THREE_MATCHED.calculatePrice(winningRate.threeMatchedCount)
        sum += LottoPrice.FOUR_MATCHED.calculatePrice(winningRate.fourMatchedCount)
        sum += LottoPrice.FIVE_MATCHED.calculatePrice(winningRate.fiveMatchedCount)
        sum += LottoPrice.FIVE_BONUS_MATCHED.calculatePrice(winningRate.fiveAndBonusMatchedCount)
        sum += LottoPrice.SIX_MATCHED.calculatePrice(winningRate.sixMatchedCount)
        return "%.2f".format(sum.toDouble() / purchasedAmount.toDouble() * 100).toDouble()
    }
}