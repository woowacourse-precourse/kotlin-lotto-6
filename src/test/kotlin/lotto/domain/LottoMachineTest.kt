package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `구입금액에 따라 로또를 생성하는 기능 테스트 1`() {
        val lottoMachine = LottoMachine(5000)
        val lottos = lottoMachine.issueLottos()
        val expectedLottosSize = 5
        assertThat(expectedLottosSize).isEqualTo(lottos.size)
    }

    @Test
    fun `구입금액에 따라 로또를 생성하는 기능 테스트 2`() {
        val lottoMachine = LottoMachine(9595000)
        val lottos = lottoMachine.issueLottos()
        val expectedLottosSize = 9595
        assertThat(expectedLottosSize).isEqualTo(lottos.size)
    }

    @Test
    fun `pickUniqueNumbersInRange 메서드 테스트`() {
        repeat(10000) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val numbersSet = numbers.toSet()
            assertThat(numbers).hasSize(6)
            assertThat(numbers.size).isEqualTo(numbersSet.size)
            assertThat(numbers).allMatch { number ->
                number in 1..45
            }
        }
    }
}