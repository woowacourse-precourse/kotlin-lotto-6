package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.fake.FakeNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RandomNumberGeneratorTest{
    @Test
    fun `랜덤으로 생성된 숫자는 6개여야한다`(){
        //given
        val randomNumberGenerator = RandomNumberGenerator()

        //when
        val actual = randomNumberGenerator.generateNumber().size

        //then
        val expected = LOTTO_NUMBER_COUNT
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `랜덤으로 생성된 숫자는 다 다른 6개의 숫자여야한다`(){
        //given
        val randomNumberGenerator = RandomNumberGenerator()

        //when
        val actual = randomNumberGenerator.generateNumber().toSet().size

        //then
        val expected = LOTTO_NUMBER_COUNT
        assertThat(actual).isEqualTo(expected)
    }
}