package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.model.Bonus
import lotto.model.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest : NsTest() {
    @Test
    fun `보너스가 답과 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Bonus().BonuDuplicationValidate(1, listOf(1,2,3,4,5,6))
        }
    }
    override fun runMain() {
        main()
    }
}