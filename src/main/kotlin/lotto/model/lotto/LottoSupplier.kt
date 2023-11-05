package lotto.model.lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants.LOTTO_START
import lotto.constants.Constants.LOTTO_END
import lotto.constants.Constants.LOTTO_SIZE
import lotto.model.PurchaseCount

class LottoSupplier {
    fun supplyLottos(purchaseCount: PurchaseCount): Lottos {
        val lottos = Lottos()

        repeat(purchaseCount.count) {
            lottos.add(supplyLotto())
        }

        return lottos
    }

    fun supplyLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LOTTO_START.value, LOTTO_END.value, LOTTO_SIZE.value)
        return Lotto(numbers.apply { sort() })
    }
}