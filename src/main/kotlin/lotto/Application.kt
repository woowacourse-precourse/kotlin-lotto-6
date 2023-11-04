package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    val lotto = Lotto(numbers)
}
