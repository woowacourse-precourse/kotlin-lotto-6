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
}

data class MatchedData(
    var winningMatchCount: Int,
    var bonusNumber: Int,
)