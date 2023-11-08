package lotto.study

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class SetCollectionTest {
    private var numbers: HashSet<Int> = HashSet()

    @BeforeEach
    fun setUp() {
        numbers.add(1)
        numbers.add(1)
        numbers.add(2)
        numbers.add(3)
    }

    // 요구 사항 1
    @Test
    @DisplayName("Set 크기 확인하는 테스트")
    fun `Set의 크기 확인 올바른 케이스`() {
        val expectedSize = 3
        val actualSize = numbers.size
        assertEquals(expectedSize, actualSize)
    }

    // 요구 사항 2
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3]) // 테스트할 값들
    fun `Set의 contains() 메소드 테스트`(value: Int) {
        assertTrue(numbers.contains(value)) // 해당 값이 Set에 존재하는지 확인
    }

    @ParameterizedTest
    @ValueSource(ints = [6, 7, 8]) // 존재하지 않는 값들
    fun `Set의 contains() 메소드 테스트 - 존재하지 않는 값`(value: Int) {
        assertFalse(numbers.contains(value)) // 해당 값이 Set에 존재하지 않는지 확인
    }

    // 요구 사항 3
    @ParameterizedTest
    @CsvSource(value = ["1:true", "2:true", "3:true", "4:false", "5:false"], delimiter = ':')
    fun `Set의 contains() 메소드 결과 테스트`(value: Int, expectedResult: Boolean) {
        val result = numbers.contains(value)
        assertEquals(expectedResult, result)
    }

}