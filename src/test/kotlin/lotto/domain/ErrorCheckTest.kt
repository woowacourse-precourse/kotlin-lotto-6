package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorCheckTest {
    @Test
    fun blankTest() {
        assertThrows<IllegalArgumentException> {
            blankCheck("")
        }
    }

    @Test
    fun numberCheckTest() {
        assertThrows<IllegalArgumentException> {
            numberCheck("w2")
        }
    }

    @Test
    fun moneyCheckTest() {
        assertThrows<IllegalArgumentException> {
            moneyCheck(300)
        }
    }

    @Test
    fun winNumberCheckTest() {
        assertThrows<IllegalArgumentException> {
            winNumberCheck(listOf("1", "2", "3", "4", "5", "j"))
        }
    }

    @Test
    fun winBlankCheckTest() {
        assertThrows<IllegalArgumentException> {
            winBlankCheck(listOf("1", "", "2", "3", "4", "5"))
        }
    }

    @Test
    fun winNumberIndexCheckTest() {
        assertThrows<IllegalArgumentException> {
            winNumberIndexCheck(listOf("2", "3", "4"))
        }
    }

    @Test
    fun winValidNumberCheckTest() {
        assertThrows<IllegalArgumentException> {
            winNumberRangeCheck(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun winChangeNumberCheck() {
        assertThrows<IllegalArgumentException> {
            winNumberDistinctCheck(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun bonusBlankCheckTest() {
        assertThrows<IllegalArgumentException> {
            bonusBlankCheck("")
        }
    }

    @Test
    fun bonusRangeCheckTest() {
        assertThrows<IllegalArgumentException> {
            bonusRangeCheck(46)
        }
    }

    @Test
    fun bonusWinningDuplicateCheckTest() {
        val testWinningList = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            bonusWinningDuplicateCheck(testWinningList, 4)
        }
    }

    @Test
    fun bonusNumberCheck() {
        assertThrows<IllegalArgumentException> {
            bonusNumberCheck("k")
        }
    }
}