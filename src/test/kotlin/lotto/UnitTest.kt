package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UnitTest : NsTest() {

    @Test
    fun `보너스 번호에 숫자가 아닌 문자가 들어간 경우 예외가 발생한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "512abs")
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