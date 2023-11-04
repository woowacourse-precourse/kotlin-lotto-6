package lotto

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private lateinit var user: User

    @BeforeEach
    fun setUp() {
        user = User()
    }

    // 테스트 보류
    @Test
    fun `입력값이 빈 문자열이면 예외를 발생한다`() {
        // given
        val input = ""

        // when

        // then
    }

    @Test
    fun `입력값에 숫자가 아닌 문자가 포함되면 예외를 발생한다`() {
        // given
        val input = "123a"

        // when

        // then
    }

    @Test
    fun `유효하지 않은 금액 단위이면 예외를 발생한다`() {
        // given
        val input = "3500"

        // when

        // then
    }

    @Test
    fun `올바른 입력값에 대해 예상한 결과와 일치한다`() {
        // given
        val input = "1000"

        // when

        // then
    }
}