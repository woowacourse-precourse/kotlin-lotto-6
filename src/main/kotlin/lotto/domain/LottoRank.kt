package lotto.domain

enum class LottoRank(val rankDescription: String, val prizeMoney: Int) {
    FIFTH("3개 일치", 5_000),
    FOURTH("4개 일치", 50_000),
    THIRD("5개 일치", 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    FIRST("6개 일치", 2_000_000_000);

}