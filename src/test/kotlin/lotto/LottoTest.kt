package lotto

import lotto.model.isDigit
import lotto.model.isLottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


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

    @Test
    fun `로또 번호의 개수가 6개 보다 작으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "46", "100", "-5"])
    fun `로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.isLottoNumber()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["q", "`", "ㅂ"])
    fun `로또 번호가 숫자가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.isDigit()
        }
    }
}
