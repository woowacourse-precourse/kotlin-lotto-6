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

    fun calWinningRate(
        lottoList: List<Lotto>,
        winningList: List<Int>,
        bonusNumber: Int
    ): WinningRate {
        val dataList = calMatchCount(lottoList, winningList, bonusNumber)
        val winningRate = WinningRate()
        dataList.forEach {
            when {
                it.winningMatchCount == 3 && it.bonusNumber == 0 -> winningRate.threeMatchedRate += 1
                it.winningMatchCount == 4 && it.bonusNumber == 0 -> winningRate.fourMatchedRate += 1
                it.winningMatchCount == 5 && it.bonusNumber == 0 -> winningRate.fiveMatchedRate += 1
                it.winningMatchCount == 5 && it.bonusNumber == 1 -> winningRate.fiveAndBonusMatchedData += 1
                it.winningMatchCount == 6 && it.bonusNumber == 0 -> winningRate.sixMatchedRate += 1
            }
        }
        return winningRate
    }
}

data class MatchedData(
    var winningMatchCount: Int,
    var bonusNumber: Int,
)

data class WinningRate(
    var threeMatchedRate: Int = 0,
    var fourMatchedRate: Int = 0,
    var fiveMatchedRate: Int = 0,
    var fiveAndBonusMatchedData: Int = 0,
    var sixMatchedRate: Int = 0
)