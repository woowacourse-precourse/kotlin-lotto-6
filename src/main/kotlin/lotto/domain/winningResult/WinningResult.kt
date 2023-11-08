package lotto.domain.winningResult

class WinningResult(
    val result: Map<WinningRank, MatchCount>,
    val rateOfReturn: RateOfReturn
) {
    override fun toString(): String {
        val sb = StringBuilder()
        result.forEach { (rank, count) ->
            if (rank == WinningRank.NONE) return@forEach
            sb.append("${rank.description} (${rank.prize}) - ${count}${System.lineSeparator()}")
        }
        sb.append("총 수익률은 ${rateOfReturn}입니다.")
        return sb.toString()
    }
}