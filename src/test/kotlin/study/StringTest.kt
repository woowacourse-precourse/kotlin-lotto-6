package study

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class StringTest {

    @Test
    fun `"1,2"를 ,로 split 했을 때 1과 2로 잘 분리되었는지 확인`() {
        // Given
        val given = "1,2"

        // When
        val result = given.split(",")

        // Then
        assertThat(result).contains("1", "2")
    }
}