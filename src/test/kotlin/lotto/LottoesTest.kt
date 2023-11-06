package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoesTest {

    private lateinit var lottoes: Lottoes

    @ParameterizedTest
    @CsvSource("1000, 1", "3000, 3", "10000, 10", "15000, 15", "100000, 100", "0, 0")
    fun `구입할 금액에서 1,000 으로 나눈 구입한 로또 수량이다`(input: String, expected: Int) {
        lottoes = Lottoes(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))), "1, 2, 3, 4,5, 6")
        val result = lottoes.calculateQuantity(input)
        assertThat(result).isEqualTo(expected)
    }
}