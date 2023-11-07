package domain.result

data class FinalResult(
    val winningData: Map<Rank, Int>,
    val rateOfReturn: String
)
