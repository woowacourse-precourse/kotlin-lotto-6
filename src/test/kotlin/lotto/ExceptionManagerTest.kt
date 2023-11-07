package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExceptionManagerTest {
    val exceptionManager = ExceptionManager()

    @Test
    fun `구입 금액이 숫자가 아니면 에러가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.money("abc")
        }
    }

    @Test
    fun `구입 금액이 0보다 작으면 에러가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.money("-1")
        }
    }

    @Test
    fun `구입 금액이 1,000원으로 나누어 떨어지지 않으면 에러가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.money("1001")
        }
    }
}