package lotto

enum class LottoPrize(val value: Int, var count: Int, val prizeMoney: Int) {
    JACKPOT(6, 0, 2_000_000_000),
    SECOND_PRIZE(5, 0,30_000_000),
    THIRD_PRIZE(5, 0,1_500_000),
    FOUTRH_PRIZE(4, 0,50_000),
    FIFTH_PRIZE(3, 0,5_000)
}