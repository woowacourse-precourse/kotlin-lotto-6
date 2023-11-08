package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoShopTest : NsTest() {

    @Test
    fun `로또 구입 금액이 비어있을 경우의 예외처리`() {
        assertSimpleTest {
            PURCHASE_MESSAGE
            runException(" ")
            assertTrue(output().contains(ERROR_PRICE_BLANK))
        }
    }

    @Test
    fun `로또 구입 금액이 숫자가 아닐 경우의 예외처리`() {
        assertSimpleTest {
            PURCHASE_MESSAGE
            runException("aaa")
            assertTrue(output().contains(ERROR_PRICE_NOT_NUM))
        }
    }

    @Test
    fun `로또 구입 금액이 천원 단위가 아닐 경우의 예외처리`() {
        assertSimpleTest {
            PURCHASE_MESSAGE
            runException("1250")
            assertTrue(output().contains(ERROR_PRICE_NOT_1000_UNIT))
        }
    }

    @Test
    fun `로또 구입 금액이 10만원을 초과했을 경우의 예외처리`() {
        assertSimpleTest {
            PURCHASE_MESSAGE
            runException("120000")
            assertTrue(output().contains(ERROR_PRICE_LIMIT))
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        const val PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        const val ERROR_PRICE_BLANK = "[ERROR] 로또 구입 금액은 천원 이상으로 입력 가능합니다."
        const val ERROR_PRICE_NOT_NUM = "[ERROR] 로또 구입 금액은 숫자로만 입력 가능합니다."
        const val ERROR_PRICE_NOT_1000_UNIT = "[ERROR] 로또 구입 금액은 천원 단위로만 입력 가능합니다."
        const val ERROR_PRICE_LIMIT = "[ERROR] 로또 구입은 10만원까지만 가능합니다."
    }
}