package lotto

import lotto.enums.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번후가 6개이고 중복된 숫자가 없을 때 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 번호가 문자열로 올바르게 변환되는지 테스트`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 45)).toString())
            .isEqualTo("[1, 2, 3, 4, 5, 45]")
    }

    @Test
    fun `로또 1등 당첨 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.calculateLottoResult(winningNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7))
            .isEqualTo(LottoResult.FIRST)
    }

    @Test
    fun `로또 2등 당첨 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(lotto.calculateLottoResult(winningNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7))
            .isEqualTo(LottoResult.SECOND)
    }

    @Test
    fun `로또 3등 당첨 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        assertThat(lotto.calculateLottoResult(winningNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7))
            .isEqualTo(LottoResult.THIRD)
    }

    @Test
    fun `로또 4등 당첨 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 44, 45))
        assertThat(lotto.calculateLottoResult(winningNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7))
            .isEqualTo(LottoResult.FOURTH)
    }

    @Test
    fun `로또 5등 당첨 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 43, 44, 45))
        assertThat(lotto.calculateLottoResult(winningNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7))
            .isEqualTo(LottoResult.FIFTH)
    }

    @Test
    fun `로또 꽝 테스트`() {
        val lotto = Lotto(listOf(1, 2, 42, 43, 44, 45))
        assertThat(lotto.calculateLottoResult(winningNumbers = listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7))
            .isEqualTo(LottoResult.NOTHING)
    }

    @Test
    fun `로또 결과 문자열 변환 테스트`() {
        assertThat(LottoResult.THIRD.toString(winningCount = 10))
            .isEqualTo("5개 일치 (1,500,000원) - 10개")
    }
}
