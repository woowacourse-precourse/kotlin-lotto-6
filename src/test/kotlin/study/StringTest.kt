package study

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

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
}