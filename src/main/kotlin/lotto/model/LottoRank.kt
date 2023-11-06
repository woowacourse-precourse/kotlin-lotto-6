package lotto.model

enum class LottoRank(val matchCount: Int, val bonusNumber: String, val prize: Int) {
    FIFTH(3, "", 5000),
    FOURTH(4, "", 50000),
    THIRD(5, "", 1500000),
    SECOND(5, ", 보너스 볼 일치", 30000000),
    FIRST(6, "", 2000000000),
    NONE(-1, "", 0),
}