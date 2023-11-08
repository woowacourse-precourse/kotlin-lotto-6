package lotto.domain

enum class LottoRank(val message: String, val prize: Prize) {
    FIRST("6개 일치", Prize(FIRST_PRIZE)),
    SECOND("5개 일치, 보너스 볼 일치", Prize(SECOND_PRIZE)),
    THIRD("5개 일치", Prize(THIRD_PRIZE)),
    FOURTH("4개 일치", Prize(FOURTH_PRIZE)),
    FIFTH("3개 일치", Prize(FIFTH_PRIZE)),
    NOTHING("꽝", Prize(NOTHING_PRIZE)),
    INIT("기본", Prize(NOTHING_PRIZE)),
}

private const val FIRST_PRIZE = 2_000_000_000
private const val SECOND_PRIZE = 30_000_000
private const val THIRD_PRIZE = 1_500_000
private const val FOURTH_PRIZE = 50_000
private const val FIFTH_PRIZE = 5_000
private const val NOTHING_PRIZE = 0