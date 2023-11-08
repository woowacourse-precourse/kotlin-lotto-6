package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMaker {

    fun createRandomLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun createRandomBonusNumbers(): Int {
        return Randoms.pickNumberInRange(1, 45)
    }
}