package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Constants.AMOUNT_ERROR
import lotto.Constants.BONUS_ERROR
import lotto.Constants.WIN_NUM_ERROR
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AskTest : NsTest() {
    @ParameterizedTest
    @ValueSource(strings = [" ", "hi", "0", "100"])
    fun `로또금액 입력 예외 테스트`(amount: String) {
        assertSimpleTest {
            runException(amount)
            assertThat(output()).contains(AMOUNT_ERROR)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,1,2,3,4,5", "1,2,3,4,5,65", "ㅇ,1,2,3,4,5", "0,1,2,3,4,5"])
    fun `당첨번호 입력 예외 테스트`(winNum: String) {
        assertSimpleTest {
            runException("1000", winNum)
            assertThat(output()).contains(WIN_NUM_ERROR)
        }
    }

    @Test
    fun `당첨번호 입력 - 쉼표 기준으로 구분 테스트`() {
        assertSimpleTest {
            val result = Ask().validWinNum("1,2,3,4,5,6")
            assertThat(result).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["hi", "1", "65", "0"])
    fun `보너스번호 입력 예외 테스트`(bonusNum: String) {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", bonusNum)
            assertThat(output()).contains(BONUS_ERROR)
        }
    }

    override fun runMain() {
        main()
    }
}