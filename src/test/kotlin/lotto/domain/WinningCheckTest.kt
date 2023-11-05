package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class WinningCheckTest {

    @Test
    fun gradeCheck() {
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList,listOf(1,2,3,4,5,6),7)
        assertThat(testGrade[0].correct).isEqualTo(6)
    }


}