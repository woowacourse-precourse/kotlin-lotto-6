package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {

    internal fun create() =
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
}