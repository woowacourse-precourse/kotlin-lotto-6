package study

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTest {
    //요구사항 1
    @Test
    fun `"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 테스트`() {
        val str = "1,2"
        val splitResult = str.split(",")
        assert(splitResult.contains("1"))
        assert(splitResult.contains("2"))
    }

    @Test
    fun `1을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트`() {
        val str = "1"
        val splitResult = str.split(",")
        assert(splitResult.contains("1"))
    }

    //요구사항 2

    @Test
    fun `"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()를 제거하고 "1,2"를 반환하도록 구현`() {
        val str = "(1,2)"
        val result = str.substring(1, str.length - 1)
        println(result)
        assert(result == "1,2")
    }

    //요구사항 3

    @Test
    fun `"abc" 값이 주어졌을 때 String의 charAt()메소드를 활용해 특정 위치의 문자를 가져오는 테스트`() {
        val str = "abc"
        assert(str.elementAt(index = 0) == 'a')
    }

    @Test
    @DisplayName("index 범위 벗어날 때 에러 체크")
    fun `특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생하는 지 테스트`() {
        val str = "abc"
        assertThatThrownBy { str.elementAt(5) }.hasMessageContaining("String index out of range:")
    }
}