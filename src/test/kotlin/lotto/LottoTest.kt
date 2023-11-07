package lotto

import domain.lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {

    lateinit var lotto: Lotto
    lateinit var inputLotties: MutableList<List<Int>>
    lateinit var expectedResult: MutableList<List<Int>>

    @BeforeEach
    fun setup() {
        inputLotties = mutableListOf(
            listOf(21, 8, 23, 43, 41, 42),
            listOf(5, 38, 16, 32, 11, 3),
            listOf(35, 7, 44, 16, 36, 11),
            listOf(8, 42, 31, 1, 11, 41),
        )

        expectedResult = mutableListOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
        )
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `구매한 로또 정렬 테스트`() {
        inputLotties.zip(expectedResult) { inputItem, expectedItem ->
            lotto = Lotto(inputItem)
            val actualResult = lotto.sortedRandomNumbers()
            assertThat(actualResult).isEqualTo(expectedItem)
        }
    }
}
