package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `범위를 벗어난 보너스 번호인 경우 예외가 발생한다`(number: Int) {
        //when
        val exception = assertThrows<IllegalArgumentException> { Bonus(number) }

        //then
        assertThat(exception.message).isEqualTo(Bonus.INVALID_NUMBER_RANGE_ERROR_MESSAGE)
    }
}