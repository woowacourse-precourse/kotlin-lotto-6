package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoInputTest : NsTest() {

    @Test
    fun `당첨 번호 길이,중복 유효성 검사`() {
        assertSimpleTest {
            run("1000", "1,2,3,4,5", "1,2,3,4,5,6", "1", "8")
            assertThat(output()).contains(
                "[ERROR] 당첨번호의 숫자가 6자리가 아닙니다.",
                "[ERROR] 당첨번호의 숫자에 중복이 존재합니다."
            )
        }
    }

    @Test
    fun `당첨 번호 입력 문자 검사`() {
        assertSimpleTest {
            run("1000", "1,2,3,4,5,ㄴ", "1,2,3,4,5,6", "8")
            assertThat(output()).contains("[ERROR] 입력하신 값은 자연수가 아닙니다.")
        }
    }

    @Test
    fun `당첨 번호 입력 범위 검사`() {
        assertSimpleTest {
            run("1000", "1,2,3,4,5,47", "1,2,3,4,5,6", "8")
            assertThat(output()).contains("[ERROR] 번호가 1부터 45까지의 숫자가 아닙니다.")
        }
    }

    @Test
    fun `보너스  번호 범위에 대한 유효성 검사`() {
        assertSimpleTest {
            run("1000", "1,2,3,4,5,6", "46", "7")
            assertThat(output()).contains("[ERROR] 번호가 1부터 45까지의 숫자가 아닙니다.")
        }
    }

    @Test
    fun `보너스 번호 입력 문자 검사`() {
        assertSimpleTest {
            run("1000", "1,2,3,4,5,6", "s", "7")
            assertThat(output()).contains("[ERROR] 입력하신 값은 자연수가 아닙니다.")
        }
    }

    override fun runMain() {
        LottoInput.putWiningNumbers()
        LottoInput.putBonusNumber()
    }


}