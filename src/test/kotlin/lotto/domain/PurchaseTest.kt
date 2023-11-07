package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseTest {
    private lateinit var purchase: Purchase

    @BeforeEach
    fun setUp() {
        purchase = Purchase()
    }

    @Test
    fun `입력 금액이 없을 때`() {
        val input = ""

        val exception = assertThrows<IllegalArgumentException> {
            purchase.payMoney(input)
        }

        assertEquals(NOT_EMPTY, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "      "])
    fun `입력 금액이 공백일 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            purchase.payMoney(input)
        }

        assertEquals(NOT_BLANK, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["   ㅠㅠ", "3주차 너무 어려워요...", "!@#@!#$", "asfasdf", "가나다라", "2147484000", "-2147484000"])
    fun `입력 금액이 정수가 아닐 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            purchase.payMoney(input)
        }

        assertEquals(ONLY_INT, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1234", "0", "-2147483000"])
    fun `입력 금액이 양의 정수가 아닐 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            purchase.payMoney(input)
        }

        assertEquals(ONLY_POSITIVE_INT, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456789", "1001", "999", "7", "2147483647"])
    fun `입력 금액이 1000원으로 나누어 떨어지지 않을 때`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            purchase.payMoney(input)
        }

        assertEquals(MUST_DIVISIBLE_BY_1000, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "2147483000"])
    fun `입력 금액이 정상일 때`(input: String) {
        assertDoesNotThrow { purchase.payMoney(input) }
    }

    companion object {
        // 사용자를 혼내는 게 아니다. 에러 메시지를 보고 제대로 입력할 수 있도록 유도해야 한다.
        const val NOT_EMPTY = "아무것도 입력하지 않았어요."
        const val NOT_BLANK = "공    백만 있어요."
        const val ONLY_INT = "숫자만 입력해 주세요. 입력 예시 -> 8000 (설마 21억 4748만 3647원보다 많이 사려는 부자는 아니겠죠?)"
        const val ONLY_POSITIVE_INT = "제 돈을 뺏어갈 속셈인가요..? 입력 예시 -> 8000"
        const val MUST_DIVISIBLE_BY_1000 = "동전은 필요 없어요. 지폐만 주세요. 입력 예시 -> 8000"
    }
}