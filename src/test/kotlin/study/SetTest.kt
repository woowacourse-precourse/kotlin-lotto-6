package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
}