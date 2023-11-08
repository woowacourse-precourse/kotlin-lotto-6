package lotto.models

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    private fun invalidNumberCountOfLotto() = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7)
        )

    @ParameterizedTest
    @MethodSource("invalidNumberCountOfLotto")
    fun `정해진 로또 번호의 개수가 아니면 예외가 발생한다`(numbers: List<Int>) {
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        assertThat(exception.message).isEqualTo(Lotto.NUMBER_COUNT_ERROR_MESSAGE)
    }

    private fun invalidNumberRangeOfLotto() = listOf(
        listOf(0, 1, 2, 3, 4, 5),
        listOf(1, 2, 3, 4, 5, 46)
    )

    @ParameterizedTest
    @MethodSource("invalidNumberRangeOfLotto")
    fun `범위를 벗어난 로또 번호가 있을 때 예외가 발생한다`(numbers: List<Int>) {
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        assertThat(exception.message).isEqualTo(Lotto.NUMBER_RANGE_ERROR_MESSAGE)
    }


   @Test
    fun `중복된 로또 번호가 있을 때 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        assertThat(exception.message).isEqualTo(Lotto.DISTINCT_NUMBER_ERROR_MESSAGE)
    }
}
