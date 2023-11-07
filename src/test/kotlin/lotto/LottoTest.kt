package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


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
        assertThrows<IllegalArgumentException>("[ERROR] 당첨 번호에 동일한 숫자를 입력할 수 없습니다.") {
            val lotto = Lotto(listOf(1,2,3,4,5,5))
            val lottoSize = lotto.getNumbers().size
            val distinctLottoSize = lotto.getNumbers().distinct().size
            assertThat(lottoSize).isNotEqualTo(distinctLottoSize)
        }
    }


    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다`() {
        val price = 1234
        assertThrows<IllegalArgumentException>("[ERROR] 로또 구매 금액은 1,000원 단위로 입력 되어야 합니다.") {
            require(price % 1000 == 0)
        }
    }
}
