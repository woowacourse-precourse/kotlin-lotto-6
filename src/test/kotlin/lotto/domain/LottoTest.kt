package lotto.domain

import lotto.domain.fake.FakeNumberGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = [7, 8, 9, 10])
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`(input: Int) {
        //given
        val numberGenerator = FakeNumberGenerator(input)
        val generatedNumbers = numberGenerator.generateNumbers()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            Lotto(generatedNumbers)
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호에 음수가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, -2, -3, -4, -5, -6))
        }
    }

    @Test
    fun `로또 번호에 46이상의 수가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 47, 48, 49, 50, 51))
        }
    }
}
