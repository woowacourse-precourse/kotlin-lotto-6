package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserInputMessageTest : NsTest() {

    @Test
    fun `구입금액, 당첨 번호, 보너스번호 입력 메시지가 적절하게 나오는지 여부`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            run("5000", "1,2,3,4,5,6", "7")
            assertThat(output()).contains(
                "구입금액을 입력해 주세요.",
                "당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요.",
            )
        }
    }

    override fun runMain() {
        main()
    }
}