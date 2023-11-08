package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoNumProducer {

    fun getLottoRandomNums(): List<Int> {

        return Randoms.pickUniqueNumbersInRange(1, 45, 6)

    }


}