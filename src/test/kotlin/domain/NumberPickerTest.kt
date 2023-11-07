package domain

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
        assertThat(numberPicker.getRandomNumbers()).hasSize(8)
    }
}