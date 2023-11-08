package lottonumbergenerator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberGeneratorTest {

    private lateinit var lottoNumberGenerator: LottoNumberGenerator

    @BeforeEach
    fun setUp() {
        lottoNumberGenerator = LottoNumberGeneratorImpl()
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "3, 3",
        "4, 4",
        "50, 50",
        "100, 100",
    )
    fun `발행한 로또 갯수 만큼 로또 갯수가 만들어지는지 확인`(input: Int, output: Int) {
        lottoNumberGenerator.generateLotto(input)

        val result = lottoNumberGenerator.lottoes

        assertThat(result).hasSize(output)
    }

    @RepeatedTest(100)
    fun `발행한 로또가 오름차순으로 정렬되는지 확인`() {
        lottoNumberGenerator.generateLotto(1)

        val result = lottoNumberGenerator.lottoes

        for (index in result.indices) {
            assertThat(result[index].getNumbers()).isSorted
        }
    }
}