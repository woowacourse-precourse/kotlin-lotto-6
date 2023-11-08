package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoProgram {
    var count: Int = 0

    fun makeCalculationMoney(money: Int) {
        this.count = money / 1000
    }

    fun makeRandomNumbers(): List<Int>? {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }


}