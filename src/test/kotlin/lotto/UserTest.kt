package lotto

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserTest {
    private lateinit var user: User

    @BeforeEach
    fun setUp() {
        user = User()
    }

    // 테스트 보류
    @Test
    fun `금액 입력값이 빈 문자열이면 예외를 발생한다`() {
        // given
        val input = ""

        // when

        // then
    }

    @Test
    fun `금액 입력값에 숫자가 아닌 문자가 포함되면 예외를 발생한다`() {
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
    fun `올바른 금액 입력값에 대해 예상한 결과와 일치한다`() {
        // given
        val input = "1000"

        // when

        // then
    }

    @Test
    fun `당천 번호 입력값이 빈 문자열인 경우 예외를 발생한다`() {
        // given
        val input = listOf(
            "", ",", ", 2, 3", "1, , 3", "1, 2, "
        )

        // when

        // then
    }

    @Test
    fun `당첨 번호 입력값에 구분자 외 숫자가 아닌 문자가 포함되면 예외를 발생한다`() {
        // given
        val input = listOf(
            "a", "a,", ",b", "a, 1", "1, b,", "a, b"
        )

        // when

        // then
    }

    @Test
    fun `당첨 번호가 6개가 아닐 때 예외를 발생한다`() {
        // given
        val input = listOf(
            "1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 6, 7"
        )

        // when

        // then
    }

    @Test
    fun `당첨 번호의 범위가 1이상 45이하가 아니면 예외가 발생한다`() {
        // given
        val input = listOf(
            "1, 2, 3, 4, 5, 45",
            "0, 1, 2, 3, 4, 5"
        )

        // when

        // then
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        // given
        val input = "1, 2, 3, 4, 5, 5"

        // when

        // then
    }

    @Test
    fun `올바른 당첨 번호 입력값에 대해 예상한 결과와 일치한다`() {
        // given
        val input = "1, 2, 3, 4, 5, 6"
        val expectedWinningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when

        // then
    }

    @Test
    fun `보너스 번호 입력값이 빈 문자열인 경우 예외를 발생한다`() {
        // given
        val input = ""

        // when

        // then
    }

    @Test
    fun `보너스 번호 입력값에 숫자가 아닌 문자가 포함되면 예외를 발생한다`() {
        // given
        val input = listOf(
            "1a", "1,", "a"
        )

        // when

        // then
    }

    @Test
    fun `올바른 보너스 번호 입력값에 대해 예상한 결과와 일치한다`() {
        // given
        val input = "1"
        val expectedBonusNumber = 1

        // when

        // then
    }
}