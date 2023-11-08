package lotto.view

import lotto.domain.IssueLotto

class Output {
    fun printResult(result: MutableList<Int>, bonusResult: MutableList<Int>): Int{
        var three = 0
        var four = 0
        var five = 0
        var bonusFive = 0
        var six = 0
        var winAmount = 0
        for (i in result) {
            when {
                result[i] == 3 || (result[i] == 2 && bonusResult[i] == 1) -> three++
                result[i] == 4 || (result[i] == 3 && bonusResult[i] == 1) -> four++
                result[i] == 5 || (result[i] == 4 && bonusResult[i] == 1) -> five++
                result[i] == 5 && bonusResult[i] == 1 -> bonusFive++
                result[i] == 6 -> six++
            }
        }
        winAmount = (three*5000) + (four*50000) + (five*1500000) + (bonusFive*30000000) + (six*2000000000)
        winAmount
        println("3개 일치 (5,000원) - ${three}개")
        println("4개 일치 (50,000원) - ${four}개")
        println("5개 일치 (1,500,000원) - ${five}")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${bonusFive}개")
        println("6개 일치 (2,000,000,000원) - ${six}개")

        return winAmount
    }
}