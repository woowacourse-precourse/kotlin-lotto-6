package lotto.domain

data class FinalResult(
        val winningData: Map<Rank, Int>,
        val rateOfReturn: String
)
