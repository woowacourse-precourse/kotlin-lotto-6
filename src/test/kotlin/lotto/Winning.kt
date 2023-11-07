package lotto

import lotto.domain.WinningNumber
import lotto.domain.Winning
import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class Winning {
    @Test
    fun `당첨 번호가 6개가 아니다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber.publicCheckValidationWinningNumber(listOf(1,2,3,4,5,6,7))
        }
    }

    @Test
    fun `당첨 번호에 중복이 존재한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber.publicCheckValidationWinningNumber(listOf(1,2,3,4,4,5))
        }
    }

    @Test
    fun `당첨 번호에 1미만 혹은 45초과의 숫자가 존재한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber.publicCheckValidationWinningNumber(listOf(1,2,3,4,5,46))
            WinningNumber.publicCheckValidationWinningNumber(listOf(0,2,3,4,5,6))
        }
    }

    @Test
    fun `당첨 번호와 로또 번호의 당첨개수 확인`() {
        val testWinningNumber = mutableListOf(1,2,3,11,12,13)
        WinningNumber.testSetWinningIntNumber(testWinningNumber)
        assertThat(Winning.publicCompareNumberWithWinningNumber(Lotto(listOf(1,2,3,4,5,6)))).isEqualTo(3)
        assertThat(Winning.publicCompareNumberWithWinningNumber(Lotto(listOf(1,2,4,5,6,7)))).isEqualTo(2)
    }

    @Test
    fun `당첨 결과에 따른 순위 계산`() {
        assertThat(Winning.publicSetWinningRate(3,true)).isEqualTo(Winning.LottoInfor.FIFTH)
        assertThat(Winning.publicSetWinningRate(5,true)).isEqualTo(Winning.LottoInfor.SECOND)
        assertThat(Winning.publicSetWinningRate(5,false)).isEqualTo(Winning.LottoInfor.THIRD)
        assertThat(Winning.publicSetWinningRate(6,false)).isEqualTo(Winning.LottoInfor.FIRST)
    }

    @Test
    fun `수익률 계산`() {
        val testInput = mutableListOf<Winning.LottoInfor>()
        testInput.add(Winning.LottoInfor.SECOND)
        testInput.add(Winning.LottoInfor.THIRD)
        //8000원 주고 샀을 때
        val lottoCount = 8
        assertThat(Winning.publicCalculateEarningRate(testInput,lottoCount)).isEqualTo("393,750.0")
    }
}
