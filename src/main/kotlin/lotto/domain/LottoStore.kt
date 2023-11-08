package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Lotto.LOTTO_START_NUMBER
import lotto.constants.Lotto.LOTTO_END_NUMBER
import lotto.constants.Lotto.LOTTO_COUNT

class LottoStore {
  private fun issueLotto(): Lotto {
    val numbers =
      Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT)
      .sorted()

    return Lotto(numbers)
  }

  fun sellIssuedLottos(purchaseAmount: Int): List<Lotto> {
    val issuedLottos = mutableListOf<Lotto>()

    repeat(purchaseAmount) {
      issuedLottos += issueLotto()
    }

    return issuedLottos
  }
}