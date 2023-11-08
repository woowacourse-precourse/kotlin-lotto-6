package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants
import lotto.dto.WinningAndBonusNumbers
import lotto.model.validation.LottoNumber
import lotto.util.Converter.toLottoNumbers

class Lottos(
    val lottoNumbers: List<Lotto>
) {
    fun calculateMatch(
        lottosMatchCount: LottosMatchCount,
        winningAndBonusNumbers: WinningAndBonusNumbers,
    ) {
        lottoNumbers.forEach {
            val lottoMatchResult = LottoCalculator.matchCount(
                it.numbers, winningAndBonusNumbers
            )
            lottosMatchCount.update(lottoMatchResult)
        }
    }

    override fun toString(): String {
        return lottoNumbers.joinToString("\n")
    }

    companion object {
        fun createRandomNumbers(count: Long): Lottos {
            return Lottos(
                List(count.toInt()) {
                    Lotto(createSortedUniqueLottoNumbers())
                }
            )
        }

        private fun createSortedUniqueLottoNumbers(): List<LottoNumber> {
            return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_RANGE_MIN_VALUE,
                Constants.LOTTO_RANGE_MAX_VALUE,
                Constants.LOTTO_NUMBER_SIZE
            )
                .sorted()
                .toLottoNumbers()
        }
    }
}