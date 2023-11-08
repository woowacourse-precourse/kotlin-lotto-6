package lotto.model

data class WinningCounts(
    var threeMatching: Int = 0,
    var fourMatching: Int = 0,
    var fiveMatching: Int = 0,
    var sixMatching: Int = 0,
    var fivePlusBonusMatching: Int = 0
)