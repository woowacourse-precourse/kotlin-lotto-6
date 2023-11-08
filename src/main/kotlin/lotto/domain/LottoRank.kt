package lotto.domain

enum class LottoRank(val message: String, val prize: Prize) {
    INIT("기본", Prize(0)),
    NOTHING("꽝", Prize(0)),
    FIFTH("3개 일치", Prize(5_000)),
    FOURTH("4개 일치", Prize(50_000)),
    THIRD("5개 일치", Prize(1_500_000)),
    SECOND("5개 일치, 보너스 볼 일치", Prize(30_000_000)),
    FIRST("6개 일치", Prize(2_000_000_000)),
}