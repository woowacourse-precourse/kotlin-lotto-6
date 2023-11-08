package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class IssueLotto() {
    fun calculate(amount: Int): Int {
        val quantity = amount / 1000
        return quantity
    }

    fun issue(quantity: Int) {
        for (i in 1..quantity) {
            val lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lotto.sort()
            println(lotto)
        }
    }
}