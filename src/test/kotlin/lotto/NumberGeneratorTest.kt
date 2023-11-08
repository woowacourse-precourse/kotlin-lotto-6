package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumberGeneratorTest {

    @Test
    fun `로또 번호 발생 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val numGenerator = NumberGenerator()
                val result = numGenerator.numberGenerate().toString()
                assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]")
            },
            listOf(1,2,3,4,5,6)
        )
    }

}