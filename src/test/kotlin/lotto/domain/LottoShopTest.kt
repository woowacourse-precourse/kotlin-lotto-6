package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {

    @Test
    fun `로또 구매 가격으로 문자를 입력받을 수 없다`() {
        //given
        val lottoShop = LottoShop()

        //when


        //then
        assertThrows<IllegalArgumentException>{
            lottoShop.purchaseLottos("abcd")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "101", "500", "1001", "1500"])
    fun `로또 구매 가격으로 1000의 배수가 아닌 수를 입력받을 수 없다`(input : String) {
        //given
        val lottoShop = LottoShop()

        //when


        //then
        assertThrows<IllegalArgumentException> {
            lottoShop.purchaseLottos(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "3000", "4000", "5000"])
    fun `로또 구매 가격으로 1000의 배수만을 입력받을 수 있다`(input : String) {
        //given
        val lottoShop = LottoShop()

        //when


        //then
        assertDoesNotThrow {
            lottoShop.purchaseLottos(input)
        }
    }

    @Test
    fun `로또 구매 가격으로 0원을 입력받을 수 없다`() {
        //given
        val lottoShop = LottoShop()

        //when


        //then
        assertThrows<IllegalArgumentException> {
            lottoShop.purchaseLottos("0")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "3000", "4000", "5000"])
    fun `로또는 한 장당 1000원에 구매할 수 있다`(input : String) {
        //given
        val lottoShop = LottoShop()

        //when


        //then
        val actual = lottoShop.purchaseLottos(input).size
        val excepted = (input.toInt())/1000
        assertThat(actual).isEqualTo(excepted)
    }
}