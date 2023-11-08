package lotto.model

class LottoStatics(
    private val lottoManager: LottoManager
) {

    private val winStatics = mutableMapOf(
        WinningType.FIRST to 0,
        WinningType.SECOND to 0,
        WinningType.THIRD to 0,
        WinningType.FOURTH to 0,
        WinningType.FIFTH to 0,
        WinningType.NOTHING to 0
    )

    fun getWinStatics(answerNumbers: List<Int>, bonusNumber: Int): Map<WinningType, Int> {
        lottoManager.lottoes.forEach { lotto ->
            val winningType = lotto.matchAnswer(answerNumbers, bonusNumber)
            winStatics[winningType] = winStatics[winningType]!! +1
        }
        return winStatics
    }

    fun getTotalReturn(): Int {
        return winStatics.map { (winningType, num) ->
            winningType.reward * num
        }.sum()

    }

}
