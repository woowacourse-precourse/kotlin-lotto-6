package lotto.model

enum class Winning(val msg:String, val winningPrice:Int, var winningCnt: Int) {
    MatchingThreeCount("3개 일치", 5000,0),
    MatchingFourCount("4개 일치", 50000,0),
    MatchingFiveCount("5개 일치", 1500000,0),
    MatchingFiveCountWithBonus("5개 일치, 보너스 볼 일치", 30000000,0),
    MatchingSixCount("6개 일치", 2000000000,0),
}