package lotto.data.repository

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.datasource.RandomNumberDataSource
import lotto.domain.repository.LottoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class LottoRepositoryImplTest {
    private lateinit var repository: LottoRepository
    private lateinit var dataSource: RandomNumberDataSource

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    @DisplayName("로또를 구매할 갯수가 주어질 경우 해당 갯수만큼 로또를 가져옴")
    fun getLottoes_amountOfLottoesProvided_returnExactNumberOfLottoes(amount: Int) {
        // given
        dataSource = RandomNumberDataSource { startInclusive, endInclusive, count ->
            Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
        }

        repository = LottoRepositoryImpl(randomNumberDataSource = dataSource)

        // when
        val lottoes = repository.getLottoes(amount = amount)

        // then
        assertThat(lottoes.size).isEqualTo(amount)
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForLottoes")
    @DisplayName("로또 생성시 번호가 오름차순이어야 함")
    fun getLottoes_printLottoes_numbersShouldBeSortedInAscendingOrder(numbers: List<Int>) {
        // given
        dataSource = RandomNumberDataSource { _, _, _ -> numbers }
        repository = LottoRepositoryImpl(randomNumberDataSource = dataSource)

        // when
        val lottoes = repository.getLottoes(amount = DEFAULT_LOTTO_AMOUNT)

        // then
        val expected = numbers.sortedBy { it }.toString()
        lottoes.forEach { assertThat(it.toString()).isEqualTo(expected) }
    }


    companion object {
        private const val DEFAULT_LOTTO_AMOUNT = 5

        @JvmStatic
        private fun provideNumbersForLottoes(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(6, 5, 4, 3, 2, 1)),
            Arguments.of(listOf(1, 3, 5, 7, 9, 11)),
            Arguments.of(listOf(25, 42, 34, 12, 30, 7)),
        )
    }
}