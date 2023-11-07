package lotto.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class SetCollectionTest {
    private var numbers: Set<Int> = HashSet()

    @BeforeEach
    fun setUp() {
        numbers = HashSet()
        (numbers as HashSet<Int>).add(1)
        (numbers as HashSet<Int>).add(1)
        (numbers as HashSet<Int>).add(2)
        (numbers as HashSet<Int>).add(3)
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    fun `요구사항 1 테스트 코드`() {
        val size = numbers
        assertEquals(3,size)
    }

    @Test
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다")
    fun `요구사항 2 테스트 코드`(){
        @ParameterizedTest
        @ValueSource(ints = [1, 2, 3])
        fun contains(value: Int) {
            val numbers = setOf(1, 2, 3)
            assertThat(numbers.contains(value)).isTrue()
        }
    }

    @Test
    @DisplayName("1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.")
    fun `요구사항 3 테스트 코드`(){
        @ParameterizedTest
        @CsvSource("1, 2, 3, true","4, 5, false")
        fun contains(value1: Int, value2: Int, value3: Int, expectedResult: Boolean) {
            val numbers = numbers.contains(value1) && numbers.contains(value2) && numbers.contains(value3)
            assertEquals(expectedResult, numbers)
        }
    }
}