package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoProgram {
    var count: Int = 0
    var numbers: List<Int> = listOf()

    fun makeCalculationMoney(money: Int) {
        this.count = money / 1000
    }

    fun makeRandomNumbers() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }


}