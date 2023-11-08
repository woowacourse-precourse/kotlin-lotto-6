package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoProgram {
    var count: Int = 0
    var lottos:MutableList<Lotto> = mutableListOf()

    fun makeCalculationMoney(money: Int) {
        this.count = money / 1000
    }

    fun makeRandomNumbers(): List<Int> {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }

    fun makeLottos() {
        for(i in 0 until this.count) {
            val numbers = makeRandomNumbers().sorted()
            val lotto = Lotto(numbers)
            this.lottos.add(lotto)
        }
    }
}