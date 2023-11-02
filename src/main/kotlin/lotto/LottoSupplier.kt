package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.Lottos

class LottoSupplier {
    fun supplyLottos(count: Int) {
        val lottos = Lottos()

        repeat(count) {
            lottos.add(supplyLotto())
        }
    }

    fun supplyLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers.apply { sort() })
    }

}