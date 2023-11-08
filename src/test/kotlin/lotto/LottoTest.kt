package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import lotto.domain.Lotto
import lotto.domain.LottoBuyer
import lotto.domain.LottoChecker
import lotto.domain.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호 toString 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(lotto.toString(), "[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `로또 번호 정렬 테스트`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertEquals(lotto.toString(), "[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `로또번호 겹치는 개수 알아내기 테스트`() {
        val userLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winLotto = Lotto(listOf(9, 10, 11, 3, 1, 2))
        assertEquals((userLotto intersect winLotto).size, 3)
    }

    @ParameterizedTest
    @MethodSource("lottoProvider")
    fun `로또 등수 분류 테스트`(lottoNumberList: List<Int>, rightPosition: Position) {
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val lottoChecker = LottoChecker(winNumber = winLotto, bonusNumber = bonusNumber)
        val userLotto = Lotto(lottoNumberList)
        val result = lottoChecker.checkLotto(userLotto)
        assertEquals(rightPosition, result)
    }

    @Test
    fun `로또 구매 테스트`() {
        Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                val lottoBuyer = LottoBuyer(3000)
                val lottoList = lottoBuyer.lottoList
                lottoList.forEach {
                    assertEquals(it.toString(), "[1, 2, 3, 4, 5, 6]")
                }
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(6, 5, 4, 3, 2, 1),
            listOf(6, 1, 2, 5, 4, 3),
        )
    }

    companion object {
        @JvmStatic
        fun lottoProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), Position.First),
            Arguments.of(listOf(1, 2, 3, 4, 5, 7), Position.Second),
            Arguments.of(listOf(1, 2, 3, 4, 5, 8), Position.Third),
            Arguments.of(listOf(1, 2, 3, 4, 8, 9), Position.Fourth),
            Arguments.of(listOf(1, 2, 3, 8, 9, 10), Position.Fifth),
            Arguments.of(listOf(1, 2, 8, 9, 10, 11), Position.NoLuck),
        )
    }
}
