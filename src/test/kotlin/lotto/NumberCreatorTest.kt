package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberCreatorTest {
    val numberCreator = NumberCreator()
    val result = numberCreator.randoms()
    @Test
    fun `1~45범위의 숫자가 맞는지 `() {
        for (number in result) {
            assert(number in 1..45)
        }
    }

    @Test
    fun `6개의 숫자가 맞는지`(){
        assertEquals(6, result.size)
    }
    @Test
    fun `중복되지 않은 6개의 숫자인지`(){
        val uniqueNumbers = result.toSet()
        assertEquals(result.size, uniqueNumbers.size)
    }
}