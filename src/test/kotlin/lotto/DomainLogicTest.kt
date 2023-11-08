package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream


class DomainLogicTest : NsTest() {
    @ParameterizedTest
    @MethodSource("source")
    fun `랜덤번호가 변수에 잘 담기는지`(source: List<Int>) {
        Lotto(source)
        assertEquals("[1, 2, 3, 4, 5, 6]", Lotto.testLottoBall6.toString())
    }

    @ParameterizedTest
    @MethodSource("source")
    fun `잘 출력되는지`(source: List<Int>) {
        Lotto.randomBall6 = source
        if (Lotto.randomBall6.distinct().size == 6) {
            Lotto.presentRound++
            Lotto(Lotto.randomBall6.sorted())
        }
        Lotto.allDisplay()
        Assertions.assertThat(output()).contains("로또번호 1 : [1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `리스트로 잘 생성하는지`() {
        Lotto.selectBall6 = ("1,2,3,4,5,6").split(",").map { it.toInt() }
        assertEquals("[1, 2, 3, 4, 5, 6]", Lotto.selectBall6.toString())
    }

    @ParameterizedTest
    @MethodSource("source")
    fun `잘 비교하는지`(source: List<Int>) {
            var count = source.intersect(listOf(1, 3, 5, 14, 22, 45)).count()
        assertEquals(count,3)
    }

    companion object {
        @JvmStatic
        fun source(): Stream<List<Int>> {
            return Stream.of(
                listOf(1, 2, 3, 4, 5, 6)
            )
        }
    }

    override fun runMain() {
        // 메인은 호출하지 않음
    }
}