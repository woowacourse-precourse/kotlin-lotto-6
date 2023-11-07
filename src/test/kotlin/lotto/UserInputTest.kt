package lotto


import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserInputTest: NsTest() {

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }

    @Test
    fun `로또 구입 금액에 아무 것도 입력하지 않았을 경우 예외처리`() {
        assertSimpleTest {
            runException("\n")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 구입 금액이 1000의 배수가 아닐 경우 예외처리`() {
        assertSimpleTest {
            runException("5555")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 구입 금액이 0원일 경우 예외처리`() {
        assertSimpleTest {
            runException("0")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 구입 금액이 문자일 경우 예외처리`() {
        assertSimpleTest {
            runException("abc")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호가 중복 되는 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호에 1에서 45사이의 값이 오지 않는 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,46")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호의 갯수가 6개가 아닐 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호에 아무 것도 입력되지 않았을 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "\n")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호에 문자가 입력되는 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "a,b,c,d,e,f")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호에 아무것도 입력되지 않았을 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "\n")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되는 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "6")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 1에서 45사이의 값이 오지 않는 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "46")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 번호가 문자가 입력되는 경우 예외처리`() {
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `구입 금액, 당첨 번호, 보너스 번호가 적절하게 입력되는 경우`() {
        assertSimpleTest {
            run("5000", "1,2,3,4,5,6", "7")
            assertThat(output()).contains(
                "당첨 통계",
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)",
                "총 수익률은"
            )
        }
    }

    override fun runMain() {
        main()
    }
}