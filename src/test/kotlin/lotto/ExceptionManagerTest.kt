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

    @Test
    fun `당첨 번호가 숫자 리스트가 아니면 에러가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.winningNum("a,b,c")
        }
    }

    @Test
    fun `당첨 번호가 1~45가 아니면 에러가 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.winningNum("46")
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 에러가 발생한다`() {
        val winningNum = Lotto(listOf(1,2,3,4,5,6))
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.bonusNum("abc", winningNum)
        }
    }

    @Test
    fun `보너스 번호가 1~45가 아니면 에러가 발생한다`() {
        val winningNum = Lotto(listOf(1,2,3,4,5,6))
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.bonusNum("46", winningNum)
        }
    }

    @Test
    fun `보너스 번호가 당첨번호와 중복되면 에러가 발생한다`() {
        val winningNum = Lotto(listOf(1,2,3,4,5,6))
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            exceptionManager.bonusNum("6", winningNum)
        }
    }
}