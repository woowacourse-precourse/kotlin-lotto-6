package lotto.domain

import lotto.domain.fake.FakeNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = [7, 8, 9, 10])
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`(input: Int) {
        //given
        val numberGenerator = FakeNumberGenerator(input)
        val generatedNumbers = numberGenerator.generateNumbers()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            Lotto(generatedNumbers)
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호에 음수가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, -2, -3, -4, -5, -6))
        }
    }

    @Test
    fun `로또 번호에 46이상의 수가 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 47, 48, 49, 50, 51))
        }
    }

    @Test
    fun `로또 번호가 당첨 번호 및 보너스 번호와 비교했을 때 6개가 같으면 1등이다`() {
        //given
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7

        //when
        lotto.calculateWinningRank(winningNumbers, bonusNumber)
        val actual = lotto.lottoRank

        //then
        val expected = LottoRank.FIRST
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호가 당첨 번호 및 보너스 번호와 비교했을 때 5개가 같고, 보너스 번호가 같으면 2등이다`() {
        //given
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,4,5,11)
        val bonusNumber = 6

        //when
        lotto.calculateWinningRank(winningNumbers, bonusNumber)
        val actual = lotto.lottoRank

        //then
        val expected = LottoRank.SECOND
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호가 당첨 번호 및 보너스 번호와 비교했을 때 5개가 같고, 보너스 번호가 다르면 3등이다`() {
        //given
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,4,5,11)
        val bonusNumber = 12

        //when
        lotto.calculateWinningRank(winningNumbers, bonusNumber)
        val actual = lotto.lottoRank

        //then
        val expected = LottoRank.THIRD
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호가 당첨 번호 및 보너스 번호와 비교했을 때 4개가 같으면 4등이다`() {
        //given
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,4,10,11)
        val bonusNumber = 12

        //when
        lotto.calculateWinningRank(winningNumbers, bonusNumber)
        val actual = lotto.lottoRank

        //then
        val expected = LottoRank.FOURTH
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호가 당첨 번호 및 보너스 번호와 비교했을 때 3개가 같으면 5등이다`() {
        //given
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,3,9,10,11)
        val bonusNumber = 12

        //when
        lotto.calculateWinningRank(winningNumbers, bonusNumber)
        val actual = lotto.lottoRank

        //then
        val expected = LottoRank.FIFTH
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호가 당첨 번호 및 보너스 번호와 비교했을 때 2개 이하로 같으면 꽝이다`() {
        //given
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winningNumbers = listOf(1,2,8,9,10,11)
        val bonusNumber = 12

        //when
        lotto.calculateWinningRank(winningNumbers, bonusNumber)
        val actual = lotto.lottoRank

        //then
        val expected = LottoRank.NOTHING
        assertThat(actual).isEqualTo(expected)
    }
}