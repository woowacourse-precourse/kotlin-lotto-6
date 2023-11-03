package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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


    @Test
    fun `랜덤하게 생성한 로또 번호들이 중복이 있는지 확인`() {
        val generator = RandomNumbersGenerator()
        var numbers:List<Int>
        repeat(100000) {
            numbers = generator.makeRandomNumbers()
            Assertions.assertEquals(numbers.size, numbers.distinct().size)
        }
    }

}
