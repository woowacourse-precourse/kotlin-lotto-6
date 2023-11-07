package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class WinningCheckTest {

    @Test
    fun gradeFirstCheck() {
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList, listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(testGrade[0]).isEqualTo(Grade.FIRST)
    }

    @Test
    fun gradeSecondCheck() {
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList, listOf(1, 2, 3, 4, 5, 8), 6)
        assertThat(testGrade[0]).isEqualTo(Grade.SECOND)
    }

    @Test
    fun gradeThirdCheck() {
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList, listOf(1, 2, 3, 4, 5, 8), 9)
        assertThat(testGrade[0]).isEqualTo(Grade.THIRD)
    }

    @Test
    fun gradeFourthCheck() {
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList, listOf(1, 2, 3, 4, 9, 10), 8)
        assertThat(testGrade[0]).isEqualTo(Grade.FOURTH)
    }

    @Test
    fun gradeFifthCheck() {
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList, listOf(1, 2, 3, 10, 11, 12), 7)
        assertThat(testGrade[0]).isEqualTo(Grade.FIFTH)
    }

    @Test
    fun multiGradeCheck(){
        val testList = mutableListOf<Lotto>()
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        testList.add(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        testList.add(Lotto(listOf(1, 2, 3, 4, 7, 8)))
        testList.add(Lotto(listOf(11, 21, 31, 41, 15, 16)))
        val testCheck = WinningCheck()
        val testGrade = testCheck.numbersCheck(testList, listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(testGrade[0]).isEqualTo(Grade.FIRST)
        assertThat(testGrade[1]).isEqualTo(Grade.SECOND)
        assertThat(testGrade[2]).isEqualTo(Grade.FOURTH)
        assertThat(testGrade[3]).isEqualTo(Grade.MISS)
    }

}