package lotto.view

enum class WinningPrice(val value: Int) {
    NONE(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_AND_BONUS(30000000),
    SIX(2000000000)
}