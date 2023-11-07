package lotto.data

data class Stats(
    val info: WinningInfo,
    val profitRate: Double,
) {
    override fun toString(): String {
        return """
            $info
            총 수익률은 ${profitRate * 100}%입니다.
        """.trimIndent()
    }
}
