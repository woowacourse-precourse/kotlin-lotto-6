package lotto.views

import lotto.constants.*
import lotto.domain.Lotto
import lotto.domain.WIN

object OutputView {
    fun printEnterMoney() {
        println(ENTER_MONEY)
    }

    fun printEnterWinningNumber() {
        println(ENTER_WINNING_NUMBER)
    }

    fun printEnterBonusNumber() {
        println(ENTER_BONUS_NUMBER)
    }

    fun printLotto(myLotto: List<Lotto>) {
        println("${myLotto.size}개를 구매했습니다")
        for (lotto in myLotto) {
            println(lotto.getNumbers())
        }
    }

    fun printReward(reward: List<WIN>) {
        val countMap = reward.groupingBy { it }.eachCount()

        val correctNumber = mutableListOf<Int>()

        for (entry in WIN.entries) {
            val count = countMap[entry] ?: 0
            correctNumber.add(count)
        }

        println("3개 일치 (5,000원) - ${correctNumber[4]}개")
        println("4개 일치 (50,000원) - ${correctNumber[3]}개")
        println("5개 일치 (1.500,000원) - ${correctNumber[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${correctNumber[1]}개")
        println("6개 일치 (2,000,000,000원) - ${correctNumber[0]}개")

    }
}