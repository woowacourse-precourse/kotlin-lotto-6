package lotto.study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun `요구사항 1 contains 테스트 코드`(){
        val input= "1,2"
        val inputSplit = input.split(",").map { it.trim() }
        assertThat(inputSplit.contains("1"))
        assertThat(inputSplit.contains("2"))

    }

    @Test
    fun `요구사항 1 containsExactly 테스트 코드`(){
        val input = "1"
        val inputSplit = input.split(",").map { it.trim() }
        assertThat(inputSplit).containsExactly("1")
    }

    @Test
    fun `요구사항 2 테스트 코드`(){
        val input = "(1,2)"
        val inputSplit = input.substring(1,3)
        assertThat(inputSplit.contains("1,2"))
    }

    @Test
    @DisplayName ("인덱스가 범위를 벗어날 때 StringIndexOutOfBoundsException이 발생하는지 테스트")
    // 힌트에 나와있는 예제는 java
    fun `요구사항 3 테스트 코드`(){
        val input = "abc"
        val inputChar = input[2]
        assertEquals('c', inputChar)

        val instanceOf = assertThatThrownBy {
            val outOfBoundsChar = input[input.length]
        }.isInstanceOf(StringIndexOutOfBoundsException::class.java)
    }




}