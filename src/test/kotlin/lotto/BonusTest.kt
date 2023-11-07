package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `범위를 벗어난 보너스 번호인 경우 예외가 발생한다`(number: Int) {
        val exception = assertThrows<IllegalArgumentException> { Bonus(number) }

        assertThat(exception.message).isEqualTo(Bonus.INVALID_NUMBER_RANGE_ERROR_MESSAGE)
    }

    @Test
    fun `범위 안의 보너스 번호인 경우 예외가 발생하지 않는다`() {
        val number = 1

        assertDoesNotThrow { Bonus(number) }
    }
}