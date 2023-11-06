package lotto

enum class Winning(val msg:String, val winningPrice:Int, var winningCnt: Int) {
    matchingThreeCount("3개 일치", 5000,0),
    matchingFourCount("4개 일치", 50000,0),
    matchingFiveCount("5개 일치", 1500000,0),
    matchingFiveCountWithBonus("5개 일치, 보너스 볼 일치", 30000000,0),
    matchingSixCount("6개 일치", 2000000000,0),
}