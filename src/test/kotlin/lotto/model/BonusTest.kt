package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    @DisplayName("보너스 숫자가 올바르지 않은 번호면 예외가 발생한다.")
    fun bonusConstructTest(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Bonus(-1)
            }

            assertThrows<IllegalArgumentException> {
                Bonus(46)
            }

            assertThrows<IllegalArgumentException> {
                Bonus(0)
            }
        }
    }

    @Test
    @DisplayName("보너스 숫자가 주어진 리스트에 중복된 숫자면 예외가 발생한다.")
    fun checkUniqueNumberTest(){
        val input = listOf(1, 2, 3, 4, 5, 6)
        val bonus = Bonus(1)
        assertThrows<IllegalArgumentException> {
            bonus.checkUniqueNumber(input)
        }
    }
}