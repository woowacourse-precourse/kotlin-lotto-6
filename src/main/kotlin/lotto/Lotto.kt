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

    fun checkLotto(userNumbers: List<Int>,bonusNum:Int): MutableList<Int> {
        var sameNums: MutableList<Int> = mutableListOf(0,0)
        for (i in userNumbers) {
            if (i in numbers) {
                sameNums[0] += 1
            }
            if (i == bonusNum){
                sameNums[1] += 1
            }
        }
        return sameNums
    }

    fun checkMoney(num: MutableList<Int>): Int {
        var money: Int
        if (num[0] == 3) return 5000
        if (num[0] == 4) return 50000
        if (num[0] == 5) return 1500000
        if (num[0] == 5 && num[1] == 1) return 30000000
        if (num[0] == 6) return 2000000000
        return 0
    }

}
