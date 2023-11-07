package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants

data class Lottos(
    val lottoNumbers: List<Lotto>
) {
    override fun toString(): String {
        return lottoNumbers.joinToString("\n")
    }

    companion object {
        fun create(count: Int): Lottos {
            return Lottos(
                List(count) {
                    Lotto(createSortedUniqueNumbers())
                }
            )
        }

        private fun createSortedUniqueNumbers(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_RANGE_MIN_VALUE,
                Constants.LOTTO_RANGE_MAX_VALUE,
                Constants.LOTTO_NUMBER_SIZE
            ).sorted()
        }
    }
}