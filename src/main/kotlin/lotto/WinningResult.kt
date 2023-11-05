package lotto

data class WinningResult(private val result: WinningCriteria, private val count: Int) {

    override fun toString(): String {
        return when (result) {
            WinningCriteria.SECOND -> {
                "${result.matchingNumbers}개 일치, 보너스 볼 일치 (${String.format("%,d", result.prize)}원) - ${count}개"
            }
            else -> {
                "${result.matchingNumbers}개 일치 (${String.format("%,d", result.prize)}원) - ${count}개"
            }
        }
    }
}
