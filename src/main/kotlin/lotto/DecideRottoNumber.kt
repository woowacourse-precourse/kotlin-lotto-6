package lotto

import camp.nextstep.edu.missionutils.Randoms

class DecideRottoNumber {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    fun decideRottoNumber() = numbers
}