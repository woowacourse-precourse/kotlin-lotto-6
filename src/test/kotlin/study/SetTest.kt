package study

import org.junit.jupiter.api.BeforeEach

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
}