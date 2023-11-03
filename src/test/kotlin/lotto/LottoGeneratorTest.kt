package lotto

import lotto.util.LottoGenerator
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    private val lottoGenerator = LottoGenerator()

    @Test
    @DisplayName("로또 발행 테스트")
    fun lottoPublishTest() {
        val lottoNumbers: List<Int> = lottoGenerator.lottoPublish()
        assertThat(lottoNumbers).hasSize(6).doesNotHaveDuplicates()
            .allSatisfy { value -> assertThat(value).isBetween(1, 45) }
    }
}