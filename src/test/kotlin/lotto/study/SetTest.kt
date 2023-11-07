package lotto.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

class SetTest {
    @Test
    @DisplayName("Set의 사이즈 테스트")
    fun setSizeTest() {
        val validation = numbers.size
        assertThat(validation).isEqualTo(4)
    }

    @Test
    @DisplayName("Set에 값이 들어있는지 테스트")
    fun contains() {
        assertThat(numbers.contains(1)).isTrue
        assertThat(numbers.contains(2)).isTrue
        assertThat(numbers.contains(3)).isTrue
    }

    // 파라미터화된 테스트를 실행 테스트
    @ParameterizedTest
    @ValueSource(strings = ["", "  "]) //파라미터의 값이 해당 배열의 값과 같다.
    fun isBlank_ShouldReturnTrueForNullOrBlankStrings(input: String) {
        assertTrue(input.isBlank())
    }

    // 파라미터화된 테스트를 실행 테스트
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4]) //파라미터의 값이 해당 배열의 값과 같다.
    @DisplayName("Set에 값이 들어있는지 ParameterizedTest 테스트")
    fun isContainParameter(input: Int) {
        assertTrue(numbers.contains(input))
    }

    @ParameterizedTest
    @CsvSource(value = ["1:true", "2:true", "3:true", "6:false"], delimiter = ':') //:값으로 구분
    fun inContainParameterByCsv(input: Int, expected: Boolean) {
        val actualValue = numbers.contains(input)
        assertEquals(expected, actualValue)
    }

    companion object { //BeforeAll 을 사용하고 싶으면 companion object안에 사용해야함.
        private lateinit var numbers: MutableSet<Int>

        @BeforeAll
        @JvmStatic // 단 JvmStatic 을 사용하여 자바의 제공하는 static 메소드와 동일한 동작을 하게 해야함.
        fun setUp() {
            numbers = mutableSetOf()
            numbers.add(1)
            numbers.add(2)
            numbers.add(3)
            numbers.add(4)
        }
    }
}