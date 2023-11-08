package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun makeLotto(): List<Int>? {
        var lottoNums: MutableList<Int> = pickUniqueNumbersInRange(1, 45, 6)
        return lottoNums.sorted()
    }

    fun checkLotto(userNumbers: List<Int>): Int {
        var sameNums: Int = 0
        for (i in userNumbers) {
            if (i in numbers) {
                sameNums += 1
            }
        }
        return sameNums
    }
}
