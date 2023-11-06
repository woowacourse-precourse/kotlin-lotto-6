package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class SetTest {
    private lateinit var numbers: HashSet<Int>

    @BeforeEach
    fun setUp() {
        numbers = HashSet()
        numbers.add(1)
        numbers.add(1)
        numbers.add(2)
        numbers.add(3)
    }

    @Test
    fun contains() {
        assertThat(numbers.contains(1)).isTrue()
        assertThat(numbers.contains(2)).isTrue()
        assertThat(numbers.contains(3)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun contains(input: Int) {
        assertThat(numbers.contains(input)).isTrue()
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "2, true",
        "3, true",
        "4, false",
        "5, false",
    )
    fun contains(input: Int, expected: Boolean) {
        val result = numbers.contains(input)

        assertEquals(expected, result)
    }
}