package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseCountTest {
    @Test
    @DisplayName("유효하지 않은 값이 들어가면 예외가 발생한다.")
    fun constructorTest (){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                val purchaseCount = PurchaseCount("3021")
            }

            assertThrows<IllegalArgumentException> {
                val purchaseCount = PurchaseCount("a1000")
            }

            assertThrows<IllegalArgumentException> {
                val purchaseCount = PurchaseCount("8500")
            }
        }
    }

    @Test
    @DisplayName("유효한 값이 들어가면 1000원으로 나눈 값으로 초기화한다.")
    fun validConstructTest (){
        val purchaseCount = PurchaseCount("8000")
        val validation = purchaseCount.count
        val result = 8
        assertThat(validation).isEqualTo(result)
    }
}