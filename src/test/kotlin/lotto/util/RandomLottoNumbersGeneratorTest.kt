package lotto.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("random number를 생성하는 class에서")
class RandomLottoNumbersGeneratorTest {

    @Test
    @DisplayName("1에서 45까지 6개의 서로 다른 숫자를 생성한다")
    fun generateRandomNumber() {
        //given
        val randomLottoNumbersGenerator = RandomLottoNumbersGenerator()
        //when
        val numbers = randomLottoNumbersGenerator.generate()
        val distinct = numbers.distinct()
        //then
        Assertions.assertThat(numbers.size).isEqualTo(6)
        Assertions.assertThat(distinct.size).isEqualTo(6)
        numbers.forEach { number ->
            Assertions.assertThat(number).isBetween(1, 45)
        }
    }
}