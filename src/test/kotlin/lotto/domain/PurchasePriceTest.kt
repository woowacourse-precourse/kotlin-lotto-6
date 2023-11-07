package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Lotto 구매금액을 담은 class에서")
class PurchasePriceTest {

    @Test
    @DisplayName("1000단위의 구매금액이면 오류가 발생하지 않는다")
    fun normalPurchasePrice() {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { PurchasePrice(2000) }
    }

    @Test
    @DisplayName("1000단위의 구매금액이 아니면 오류가 발생한다")
    fun notMultipleOf1000PurchasePrice() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { PurchasePrice(2100) }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("1000보다 작은 구매금액이면 오류가 발생한다")
    fun lessThan1000PurchasePrice() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { PurchasePrice(100) }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }


    @Test
    @DisplayName("구매금액에 따른 Lotto의 갯수를 계산한다")
    fun getPurchasePrice() {
        //given
        val purchasePrice = PurchasePrice(2000)
        //when
        val lottoCount = purchasePrice.calculateLottoCount()
        //then
        Assertions.assertThat(lottoCount).isEqualTo(2)
    }
}