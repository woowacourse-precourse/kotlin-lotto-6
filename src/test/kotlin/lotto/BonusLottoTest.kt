package lotto

import lotto.domain.lotto.parser.LottoNumberParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class BonusLottoTest {
    @Test
    fun `보너스 로또 번호에 Int자료형이 아닌 입력이 있으면 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoNumberParser("a")
        }
    }

    @Test
    fun `보너스 로또 번호에 Int자료형이 아닌 입력이 있으면 예외2`() {
        assertThrows<IllegalArgumentException> {
            LottoNumberParser("1a")
        }
    }

    @Test
    fun `보너스 로또 번호에 1미만인 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumberParser("0")
        }
    }

    @Test
    fun `보너스 로또 번호에 45초과인 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumberParser("46")
        }
    }
}
