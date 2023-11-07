package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMaker {

    fun createRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}