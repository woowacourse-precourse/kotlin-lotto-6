package lotto.model

import lotto.dto.LottoMatchCount
import lotto.dto.WinningAndBonusNumbers
import lotto.model.validation.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCalculatorTest {
    @Test
    fun `로또 번호와 (당첨 번호, 보너스 번호)를 비교하여 count 개수 반환`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it.toString()) })
        val winningNumbers = WinningNumbers("1, 2, 3, 4, 5, 10")
        val bonusNumber = BonusNumber("6")
        val winningAndBonusNumbers =
            WinningAndBonusNumbers(winningNumbers.numbers, bonusNumber.number)

        val data = LottoCalculator.matchCount(lotto.numbers, winningAndBonusNumbers)
        val lottoMatchCount = LottoMatchCount(winning = 5, bonus = 1)

        assertThat(data).isEqualTo(lottoMatchCount)
    }
}