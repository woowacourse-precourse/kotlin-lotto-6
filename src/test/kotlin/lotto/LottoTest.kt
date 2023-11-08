package lotto

import lotto.domain.Lotto
import lotto.domain.LottoWinResult
import lotto.validation.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복으로 입력되면 예외가 발생한다`() {
        val luckyNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 1

        assertThrows<IllegalArgumentException> {
            InputValidator.checkDuplicateBetweenBonusAndLuckyNumbers(bonusNumber, luckyNumbers)
        }
    }

    @Test
    fun `6개의 당첨 번호와 일치한다`() {
        val luckyNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val matchCount = lotto.matchNumbers(luckyNumbers)

        assertThat(matchCount).isEqualTo(6)
    }

    @Test
    fun `5개의 당첨 번호와 1개의 보너스 번호가 일치한다`() {
        val bonusNumber = 6
        val luckyNumbers = listOf(1, 2, 3, 4, 5, 9)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val matchBall = lotto.matchNumbers(luckyNumbers)
        val matchBonus = lotto.hasBonusNumber(bonusNumber)

        assertThat(matchBonus).isTrue()
        assertThat(matchBall).isEqualTo(5)
    }

    @Test
    fun `당첨 번호가 일치할 때, 당첨 결과(등수)를 알 수 있다`() {
        val luckyNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val matchCount = lotto.matchNumbers(luckyNumbers)
        LottoWinResult.calculateRank(matchCount, false)
        val ranks = LottoWinResult.getRanks()

        assertThat(ranks[LottoWinResult.ALL_MATCH.grade]).isEqualTo(1)
    }

    @Test
    fun `로또 8개를 구입한 후 5,000원에 당첨되었을 때 수익률을 알 수 있다`() {
        val luckyNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        val price = 8000

        val matchCount = lotto.matchNumbers(luckyNumbers)
        LottoWinResult.addPrizeMoney(matchCount, false)
        val totalMoney = LottoWinResult.getMoney()
        val rateOfProfit = LottoWinResult.calculateRateOfProfit(price, totalMoney)

        assertEquals(5000, totalMoney)
        assertEquals(62.5, rateOfProfit)
    }
}