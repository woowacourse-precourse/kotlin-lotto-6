package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberCreatorTest {
    @Test
    fun `1~45범위의 숫자가 맞는지 `() {
        val numberCreator = NumberCreator()
        val result = numberCreator.randoms()

        for (number in result) {
            assert(number in 1..45)
        }
    }

    @Test
    fun `6개의 숫자가 맞는지`(){
        val numberCreator = NumberCreator()
        val result = numberCreator.randoms()

        assertEquals(6, result.size)
    }
}