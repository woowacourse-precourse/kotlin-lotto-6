package lotto.domain

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.ApplicationTest
import lotto.main
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputPurchaseLottoAmountTest : NsTest() {
    @Test
    fun `구매할 금액이 숫자가 아니면 예외가 발생한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("abcd")
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `구매할 금액이 1,000원 단위가 아니면 예외가 발생한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("2500")
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}