package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

class LottoGenerator {
    fun generateLotto(): Lotto = Lotto(pickUniqueNumbersInRange(1, 45, 6).sorted().toList())
}