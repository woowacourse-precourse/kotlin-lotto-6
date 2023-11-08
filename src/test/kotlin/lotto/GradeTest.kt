package lotto

import lotto.model.Grade
import lotto.model.Lotto
import lotto.model.WinningNumber
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class GradeTest {
    @Test
    fun `로또 1개가 당첨 번호를 6개 맞았을 시 카운트가 1 증가했는지 확인`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumber = WinningNumber(Lotto(listOf(1,2,3,4,5,10)), 6)
        val grade = Grade()
        grade.decideGrade(lotto, winningNumber)
        val result = grade.getLottoGradeResult()
        assertThat(result["FIRST"]).isEqualTo(1)
    }
}