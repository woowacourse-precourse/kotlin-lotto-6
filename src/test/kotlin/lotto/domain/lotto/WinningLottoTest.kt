package lotto.domain.lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `정상적인 객체 생성`() {
        // given
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(7)
        // when & then
        assertDoesNotThrow { WinningLotto(winningNumbers, bonusNumber) }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복될 경우 예외 발생`() {
        // given
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(6)
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(winningNumbers, bonusNumber) }
            .withMessage("[ERROR] 보너스 번호가 로또 번호와 중복됩니다.")
    }
}