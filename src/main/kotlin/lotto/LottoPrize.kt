package lotto

enum class LottoPrize(val prizeMoney: Int) {
    JACKPOT(2_000_000_000),
    SECOND_PRIZE(30_000_000),
    THIRD_PRIZE(1_500_000),
    FOUTRH_PRIZE(50_000),
    FIFTH_PRIZE(5_000),
    BLACNK(0);
}