package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {

    @Test
    fun `범위를 벗어난 보너스 번호인 경우 예외가 발생한다`() {
        //given
        val number = 1

        //when
        val exception = assertThrows<IllegalArgumentException> { Bonus(number) }

        //then
        assertThat(exception.message).isEqualTo(Bonus.INVALID_NUMBER_RANGE_ERROR_MESSAGE)
    }
}