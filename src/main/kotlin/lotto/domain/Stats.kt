package lotto.domain

enum class Stats(
    val correctNumberCount: Int,
    val winningPrize: Int,
    val winningMessage: String
){
    NONE(0,  0, ""),
    FIFTH(3,  5000, " (5,000원) -"),
    FOURTH(4,  50000, " (50,000원) -"),
    THIRD(5,  1500000, " (1,500,000원) -"),
    SECOND(5,  30000000, ", 보너스 볼 일치 (30,000,000원) -"),
    FIRST(6, 2000000000, " (2,000,000,000원) -")
}

fun checkStat(matchNumbersCount: Int, bonusMatch: Boolean) : Stats {
    return when{
        matchNumbersCount == Stats.FIRST.correctNumberCount -> Stats.FIRST
        matchNumbersCount == Stats.SECOND.correctNumberCount && bonusMatch-> Stats.SECOND
        matchNumbersCount == Stats.THIRD.correctNumberCount -> Stats.THIRD
        matchNumbersCount == Stats.FOURTH.correctNumberCount -> Stats.FOURTH
        matchNumbersCount == Stats.FIFTH.correctNumberCount -> Stats.FIFTH
        else -> Stats.NONE
    }
}