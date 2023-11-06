package study

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName

class StringTest {

    @Test
    fun `"1,2"를 ,로 split 했을 때 1과 2로 잘 분리되었는지 확인`() {
        val given = "1,2"

        val result = given.split(",")

        assertThat(result).contains("1", "2")
    }

    @Test
    fun `"1"을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지 확인`() {
        val given = "1"

        val result = given.split(",")

        assertThat(result).containsExactly("1")
    }

    @Test
    fun `"(1,2)"를 substring()로 ()을 제거했을때 "1,2"를 반환하는지 확인`() {
        val given = "(1,2)"

        val result = given.substring(1, 4)

        assertThat(result).isEqualTo("1,2")
    }

    @Test
    @DisplayName("\"abc\"에서 범위를 벗어난 인덱스를 get()으로 가져올 때 예외를 던지는지 확인")
    fun `"abc" use get(3) throw IndexOutOfBoundsException`() {
        val given = "abc"

        assertThatExceptionOfType(IndexOutOfBoundsException::class.java)
            .isThrownBy {
                given.get(3)
            }.withMessage("String index out of range: 3")

        assertThatThrownBy {
            given.get(3)
        }.isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessageContaining("String index out of range: 3")
    }
}