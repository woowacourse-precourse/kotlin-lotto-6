package lotto

data class WinningRate(
    var threeMatchedCount: Int = 0,
    var fourMatchedCount: Int = 0,
    var fiveMatchedCount: Int = 0,
    var fiveAndBonusMatchedCount: Int = 0,
    var sixMatchedCount: Int = 0
)
