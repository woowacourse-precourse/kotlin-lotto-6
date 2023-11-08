package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoCreator {
    companion object {
        fun getLotto(): Lotto {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            return Lotto(lottoNumbers)
        }
    }
}