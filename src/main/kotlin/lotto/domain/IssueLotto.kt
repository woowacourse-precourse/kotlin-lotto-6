package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class IssueLotto() {
    fun calculate(amount: Int): Int {
        val quantity = amount / 1000
        return quantity
    }

    fun issue(quantity: Int): MutableList<List<Int>> {
        val userLotto = mutableListOf<List<Int>>()
        for (i in 1..quantity) {
            val lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            userLotto.add(lotto.sorted())
        }
        return userLotto
    }
}