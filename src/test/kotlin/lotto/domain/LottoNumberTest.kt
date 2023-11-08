package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

private const val OUT_RANGE_NUMBER = 46
private const val IN_RANGE_NUMBER = 1

class LottoNumberTest {
    @Test
    fun `발행된 로또 숫자의 범위가 1~45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(OUT_RANGE_NUMBER)
        }
    }

    @Test
    fun `발행된 로또 숫자의 범위가 1~45 사이면 예외가 발생하지 않는다`() {
        assertDoesNotThrow { IN_RANGE_NUMBER }
    }
}