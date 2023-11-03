package lotto.study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun `"1,2"가 ","로 잘 분리되는지 테스트`() {
        val input = "1,2"
        val validation = input.split(",")
        val result = listOf("1", "2")

        // containsExactlys는 정확하게 일치해야하는 것 같다.
        // 이렇게 사용하게 되면 굳이 리스트를 하나 더 만들어 isEqualTo를 사용할 필요가 없다!
        assertThat(validation).containsExactly("1", "2")
        assertThat(validation).isEqualTo(result)
    }

    @Test
    fun `"1"을 split하면 1만 포함하는 배열인지 테스트`() {
        val input = "1"
        val validation = input.split(",")
        assertThat(validation).containsExactly("1")
    }

    @Test
    fun `substring 테스트`() {
        val input = "(1,2)"
        val validation = input.substring(1, 4)
        assertThat(validation).isEqualTo("1,2")
    }

    @Test
    //DisplayName 을 통하여 테스트 메소드의 의미를 드러낸다.
    @DisplayName("CharAt메서드를 통해 값을 가져오는데 위치를 벗어나면 예외처리")
    fun `charAt 테스트`() {
        //Exception을 던진다.
        assertThatThrownBy {
            val input = "abc"
            input[3]
        }.isInstanceOf(IndexOutOfBoundsException::class.java) //그 예외의 타입은 IndexOutOfBoundsException 이다.
            .hasMessageContaining("index out of range: 3") // 예외 처리 메세지에는 해당 문구가 포함되어 있어야 한다.
    }

    @Test
    @DisplayName("위와 같은 표현 다른 방식")
    fun `charAt 테스트(다른 방식)`() {
        //IndexOutOfBoundsException 를 기대하는 부분
        assertThatExceptionOfType(IndexOutOfBoundsException::class.java)
                //예외를 던지는 부분
            .isThrownBy {
                val input = "abc"
                input[3]
            }.withMessageMatching("String index out of range: 3") //메세지가 정확히 일치해야 하는 부분
    }
}