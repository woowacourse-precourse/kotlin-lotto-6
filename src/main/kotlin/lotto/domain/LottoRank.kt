package lotto.domain

import lotto.constants.Lotto.FIFTH_MESSAGE
import lotto.constants.Lotto.FIFTH_REWARD
import lotto.constants.Lotto.FIRST_MESSAGE
import lotto.constants.Lotto.FIRST_REWARD
import lotto.constants.Lotto.FOURTH_MESSAGE
import lotto.constants.Lotto.FOURTH_REWARD
import lotto.constants.Lotto.SECOND_MESSAGE
import lotto.constants.Lotto.SECOND_REWARD
import lotto.constants.Lotto.THIRD_MESSAGE
import lotto.constants.Lotto.THIRD_REWARD

enum class LottoRank(val message: String, val reward: Int, var count: Int = 0) {
  FIRST(FIRST_MESSAGE, FIRST_REWARD),
  SECOND(SECOND_MESSAGE, SECOND_REWARD),
  THIRD(THIRD_MESSAGE, THIRD_REWARD),
  FOURTH(FOURTH_MESSAGE, FOURTH_REWARD),
  FIFTH(FIFTH_MESSAGE, FIFTH_REWARD);

  fun addCount() {
    count++
  }
}