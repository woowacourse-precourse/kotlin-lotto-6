package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import output.UserInterface


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>(UserInterface.NOT_INPUT_SAME_NUMBER_EXCEPTION.mention) {
            val lotto = Lotto(listOf(1,2,3,4,5,5))
            val lottoSize = lotto.getNumbers().size
            val distinctLottoSize = lotto.getNumbers().distinct().size
            assertThat(lottoSize).isNotEqualTo(distinctLottoSize)
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다`() {
        val price = 1234
        assertThrows<IllegalArgumentException>(UserInterface.INPUT_IN_UNIT_OF_THOUSANDS_EXCEPTION.mention) {
            LottoInitializer().checkPriceMultipleOfThousands(price)
        }
    }

    @Test
    fun `당첨 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> (UserInterface.UNDER_AND_OVER_NUMBER_EXCEPTION.mention) {
            val input = mutableListOf(1, 2, 3, 4, 5, 46)
            for (number in input) {
                if (number !in 1..45) {
                    throw IllegalArgumentException(UserInterface.UNDER_AND_OVER_NUMBER_EXCEPTION.mention)
                }
            }
        }
    }

    @Test
    fun `당첨 번호에 공백이 입력되면 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            val input = mutableListOf(1, 2, 3, 4, 5, 6)
            require(input.any { it.toString().contains(" ") }) {
                UserInterface.NOT_INPUT_SPACE_EXCEPTION.mention
            }
        }
    }
}
