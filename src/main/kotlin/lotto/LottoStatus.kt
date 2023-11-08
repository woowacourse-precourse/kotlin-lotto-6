package lotto

enum class LottoStatus(val count: Int) {
    SIX(6),
    FIVE_WITH_BONUS(10),
    FIVE(5),
    FOUR(4),
    THREE(3)
}