package lotto.data

data class Stats(
    val info: WinningInfo,
    val profitRate: Double,
) {

    override fun toString(): String {
        return """
            당첨 통계
            ---
            $info
            총 수익률은 ${profitRate * CORRECTION_VALUE}%입니다.
        """.trimIndent()
    }

    companion object {
        private const val CORRECTION_VALUE = 100
    }
}
