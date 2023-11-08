package lotto.model

interface Lottoes {
    fun calculateLottoesResult(): Map<WinningRank, Int>
    fun getTotalProfit(): Profit
}