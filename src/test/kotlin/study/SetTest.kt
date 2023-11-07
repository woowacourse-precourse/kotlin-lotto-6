package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class SetTest {
    private val numbers: MutableSet<Int> = mutableSetOf()

    init {
        numbers.add(1)
        numbers.add(1)
        numbers.add(2)
        numbers.add(3)
    }

    //Test Case 구현

    //요구사항 1
    //Set 의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트를 구현한다.
    @Test
    @DisplayName("Set#size() 동작 확인")
    fun test1() {
        assertThat(numbers.size == 3).isTrue()
    }

    //요구사항 2
    //Set 의 contains() 메소드를 활용해 1, 2, 3 의 값이 존재하는지 확인하는 학습 테스트 구현
    //JUnit 의 ParameterizedTest 를 활용해 중복 코드를 제거
    @ParameterizedTest
    @DisplayName("Set#contains() 동작 확인 - true")
    @ValueSource(ints = [1, 2, 3])
    fun test2(num: Int) {
        assertThat(numbers.contains(num)).isTrue()
    }

    //요구사항 3
    // 1,2,3 값은 contains 메소드 실행결과 true,
    // 4, 5 값을 넣으면 false 가 반환되는 테스트 구현
    @ParameterizedTest
    @DisplayName("Set#contains() 동작 확인 - false")
    @CsvSource("1,true", "2,true", "3,true", "4,false", "5,false")
    fun test3(input: Int, output: Boolean) {
        assertThat(numbers.contains(input) == output)
    }
}