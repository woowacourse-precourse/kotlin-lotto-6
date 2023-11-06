package lotto

import camp.nextstep.edu.missionutils.Randoms

class NumberCreator {
    fun randoms() = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}