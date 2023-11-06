package lotto.domain.lotto

import domain.lotto.NumberPicker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NumberPickerTest {

    private lateinit var numberPicker: NumberPicker

    @BeforeEach
    fun setup() {
        numberPicker = NumberPicker(8)
    }

    @Test
    fun `구매 횟수에 따른 로또 구매 시 각 로또 리스트의 번호 개수 테스트`() {
        val lottiesList: MutableList<List<Int>> = numberPicker.getRandomNumbers()
        assertThat(lottiesList).hasSize(8)
    }

    @Test
    fun `구매한 로또 정렬 테스트`() {
        val inputLotties = listOf(
            listOf(21, 8, 23, 43, 41, 23, 42, 43),
            listOf(5, 38, 16, 32, 11, 3),
            listOf(35, 7, 44, 16, 36, 11),
            listOf(8, 42, 31, 1, 11, 41),
            listOf(38, 14, 16, 45, 13, 42),
            listOf(7, 40, 42, 30, 43, 11),
            listOf(2, 38, 22, 32, 13, 45),
            listOf(22, 45, 1, 3, 5, 14,),
        )

        val expectedResult = listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
        )

        val actualResult: List<List<Int>> = numberPicker.sortRandomNumbers(inputLotties)

        /*assertThat(actualResult).isEqualto(expectedResult)*/
        actualResult.forEach {
            assertThat(it).isSorted
        }
    }
}