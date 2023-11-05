package lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


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

    @ParameterizedTest(name = "check {0}")
    @MethodSource("generateLottoAndExpectedGrade")
    @DisplayName("Lotto : checkGrade()")
    fun `로또 번호의 등수를 반환한다`(argv: LottoAndExpectedGrade) {
        // given
        val lotto = argv.lotto
        val win = argv.winningLotto
        val bonus = argv.bonus

        // when
        val actual = lotto.checkGrade(win, bonus)

        // then
        val expected = argv.grade
        assertThat(actual).isEqualTo(expected)
    }


    companion object {
        @JvmStatic
        private fun generateLottoAndExpectedGrade(): List<LottoAndExpectedGrade> {
            return listOf(
                LottoAndExpectedGrade(
                    // 1등
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    7,
                    GRADE.ONE,
                ),
                LottoAndExpectedGrade(
                    // 2등
                    Lotto(listOf(1, 2, 3, 4, 5, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    45,
                    GRADE.TWO,
                ),
                LottoAndExpectedGrade(
                    // 3등
                    Lotto(listOf(1, 2, 3, 4, 5, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    7,
                    GRADE.THREE,
                ),
                LottoAndExpectedGrade(
                    // 4등 + 보너스 당첨
                    Lotto(listOf(1, 2, 3, 4, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    15,
                    GRADE.FOUR,
                ),
                LottoAndExpectedGrade(
                    // 4등 + 보너스 미당첨
                    Lotto(listOf(1, 2, 3, 4, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    7,
                    GRADE.FOUR,
                ),
                LottoAndExpectedGrade(
                    // 5등 + 보너스 당첨
                    Lotto(listOf(1, 2, 3, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    10,
                    GRADE.FIVE,
                ),
                LottoAndExpectedGrade(
                    // 5등 + 보너스 미당첨
                    Lotto(listOf(1, 2, 3, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    25,
                    GRADE.FIVE,
                ),
                LottoAndExpectedGrade(
                    // 2개 맞춤 + 보너스 당첨
                    Lotto(listOf(1, 2, 7, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    10,
                    GRADE.LOSE,
                ),
                LottoAndExpectedGrade(
                    // 2개 맞춤 + 보너스 미당첨
                    Lotto(listOf(1, 2, 7, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    8,
                    GRADE.LOSE,
                ),
                LottoAndExpectedGrade(
                    // 1개 맞춤 + 보너스 당첨
                    Lotto(listOf(1, 7, 8, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    7,
                    GRADE.LOSE,
                ),
                LottoAndExpectedGrade(
                    // 1개 맞춤 + 보너스 미당첨
                    Lotto(listOf(1, 7, 8, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    25,
                    GRADE.LOSE,
                ),
                LottoAndExpectedGrade(
                    // 0개 맞춤 + 보너스 당첨
                    Lotto(listOf(7, 8, 9, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    7,
                    GRADE.LOSE,
                ),
                LottoAndExpectedGrade(
                    // 0개 맞춤 + 보너스 미당첨
                    Lotto(listOf(7, 8, 9, 10, 15, 45)),
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    25,
                    GRADE.LOSE,
                ),
            )
        }
    }
}
