package lotto.domain.enum.winning

enum class RankPrize(val rank:Int, val amount:Int) {
    FIRST(1,2_000_000_000),
    SECOND(2,30_000_000),
    THIRD(3,1_500_000),
    FOURTH(4,50_000),
    FIFTH(5,5_000),
    NOT(6,0)
}