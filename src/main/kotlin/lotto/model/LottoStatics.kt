package lotto.model

class LottoStatics(
    private val lottoManager: LottoManager
) {

    private val winStatics = mutableMapOf(
        WinningType.FIRST to INITIALIZE_NUM,
        WinningType.SECOND to INITIALIZE_NUM,
        WinningType.THIRD to INITIALIZE_NUM,
        WinningType.FOURTH to INITIALIZE_NUM,
        WinningType.FIFTH to INITIALIZE_NUM,
        WinningType.NOTHING to INITIALIZE_NUM
    )

    fun getWinStatics(answerNumbers: List<Int>, bonusNumber: Int): Map<WinningType, Int> {
        lottoManager.lottoes.forEach { lotto ->
            val winningType = lotto.matchAnswer(answerNumbers, bonusNumber)
            winStatics[winningType] = winStatics[winningType]!! + 1
        }
        return winStatics
    }

    fun getReturnRate(purchaseAmount: Int): String {
        val returnRate = (getTotalReturn().toDouble() / purchaseAmount) * 100
        return String.format("%.1f", returnRate)
    }

    private fun getTotalReturn(): Int {
        return winStatics.map { (winningType, num) ->
            winningType.reward * num
        }.sum()

    }

    companion object {
        private const val INITIALIZE_NUM = 0
    }

}
