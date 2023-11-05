package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants.LOTTO_START
import lotto.constants.Constants.LOTTO_END
import lotto.constants.Constants.LOTTO_SIZE
import lotto.model.lotto.Lotto
import lotto.model.lotto.Lottos

class LottoSupplier {
    fun supplyLottos(purchaseCount: Int): Lottos {
        val lottos = Lottos()

        repeat(purchaseCount) {
            lottos.add(supplyLotto())
        }

        return lottos
    }

    private fun supplyLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LOTTO_START.value, LOTTO_END.value, LOTTO_SIZE.value)
        return Lotto(numbers.apply { sort() })
    }
}