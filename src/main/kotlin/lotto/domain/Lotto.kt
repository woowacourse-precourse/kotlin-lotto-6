package lotto.domain

import lotto.view.Input

class Lotto(private val numbers: List<Int>) {
    //val userNumber = IssueLotto(amount)
    init {
        require(numbers.size == 6) {"6개 숫자 입력해야함"}
    }
    fun compare(): MutableList<Int> {
        val userNumber: MutableList<List<Int>> = IssueLotto().issue()
        //val bonusNumber: Int = Input().drawBonusNumber()
        val result = mutableListOf<Int>()
        //val user = numbers.toMutableList()
        //user.add(bonusNumber)
        for (i in userNumber.indices) {
            val r =  userNumber.filter{userNumber.contains(numbers)}
            result.add(r.size)
        }
        return result
    }
    fun bonusCompare(): MutableList<Int> {
        val bonusNumber: Int = Input().drawBonusNumber()
        val userNumber: MutableList<List<Int>> = IssueLotto().issue()
        val bonusResult = mutableListOf<Int>()
        for (i in userNumber.indices) {
            if (userNumber[i].contains(bonusNumber)) {
                bonusResult.add(1)
            }
        }
        return bonusResult
    }
}
