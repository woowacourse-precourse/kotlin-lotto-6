package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UnitTest : NsTest() {

    @Test
    fun `구입 금액 입력시 1,000원 단위가 아닌 금액을 입력했을 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            runException("800", "1,2,3,4,5,6", "13")
        }
    }

    @Test
    fun `보너스 번호에 잘 못 된 범위의 숫자를 입력했을 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            runException("800", "1,2,3,4,5,6", "133")
        }
    }

    @Test
    fun `보너스 번호에 숫자가 아닌 문자가 들어간 경우 예외가 발생한다`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "512abs")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}