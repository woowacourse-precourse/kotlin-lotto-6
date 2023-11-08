package lotto

import lotto.domain.RandomNumbersGenerator
import lotto.model.Lotto
import lotto.model.LottoRank
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }


    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }


    @Test
    fun `랜덤하게 생성한 로또 번호들이 중복이 있는지 확인`() {
        val generator = RandomNumbersGenerator()
        var numbers:List<Int>
        repeat(100000) {
            numbers = generator.makeRandomNumbers()
            Assertions.assertEquals(numbers.size, numbers.distinct().size)
        }
    }

    @Test
    fun `랜덤 생성한 로또 번호들이 오름차순 정렬 되어있는지 확인`() {
        val generator = RandomNumbersGenerator()

        var numbers: List<Int>

        repeat(100000) {
            numbers = generator.makeRandomNumbers()
            for(idx in 1 until 6) {
                assertThat(numbers[idx -1 ]).isLessThan(numbers[idx])
            }
        }
    }

    @Test
    fun `각 로또가 정답 로또와 몇개 맞았는지 계산하는 기능`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))

        var lottoRank = lotto.compareToWinningLotto(Lotto(listOf(4,3,2,1,7,8)),45)
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH)
    }


}
