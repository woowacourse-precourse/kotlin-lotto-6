package lotto

data class LottoResult(
    val statistic: Map<Rank, Int>,
    val totalPrize: Double,
)
