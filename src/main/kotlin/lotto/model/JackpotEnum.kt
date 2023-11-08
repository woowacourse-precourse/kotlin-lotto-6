package lotto.model

enum class Rank(val label: String) {
    THIRD("3개 일치"),
    FOURTH("4개 일치"),
    FIFTH("5개 일치"),
    FIFTH_WITH_BONUS("5개 + 보너스 일치"),
    SIXTH("6개 일치")
}