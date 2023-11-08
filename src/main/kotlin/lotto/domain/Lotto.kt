package lotto.domain

import lotto.view.Input

class Lotto(private val numbers: List<Int>) {
    //val userNumber = IssueLotto(amount)
    init {
        require(numbers.size == 6) {"6개 숫자 입력해야함"}
    }
    fun compare(): MutableList<Int> {
        val userNumber: MutableList<List<Int>> = IssueLotto().issue()
        val bonusNumber: Int = Input().drawBonusNumber()
        val result = mutableListOf<Int>()
        val user = numbers.toMutableList()
        user.add(bonusNumber)
        for (i in userNumber.indices) {
            val r =  userNumber.filter{userNumber.contains(user)}
            result.add(r.size)
        }
        return result
    }
}
