package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.util.Validator.isValidPurchaseAmount
import lotto.util.Validator.isValidWinningNums
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    @DisplayName("구입 금액 입력이 유효하지 않다면 예외가 발생한다")
    fun validatePurchaseAmount() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("abcd")
            }
            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("")
            }

            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount(" ")
            }

            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("-1000")
            }

            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("8765")
            }
        }
    }

    @Test
    @DisplayName("당첨 번호 입력이 유효하지 않는다면 예외를 발생한다")
    fun validateWinningNums() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                isValidWinningNums("")
            }
            assertThrows<IllegalArgumentException> {
                isValidWinningNums("1,2,3, ,5,6")
            }
            assertThrows<IllegalArgumentException> {
                isValidWinningNums("1,2")
            }
            assertThrows<IllegalArgumentException> {
                isValidWinningNums("a,b,c,d,e,f")
            }
            assertThrows<IllegalArgumentException> {
                isValidWinningNums("1,1,2,3,4,5")
            }
            assertThrows<IllegalArgumentException> {
                isValidWinningNums("0,2,3,4,47,100")
            }
        }
    }
}
