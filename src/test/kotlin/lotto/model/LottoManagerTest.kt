package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.TestCaseArguments.CHECK_LOTTO_TEST_CASE_FAIL_BONUS_NOT_INIT
import lotto.TestCaseArguments.CHECK_LOTTO_TEST_CASE_SUCCESS_FIFTH
import lotto.TestCaseArguments.CHECK_LOTTO_TEST_CASE_SUCCESS_FIRST
import lotto.TestCaseArguments.CHECK_LOTTO_TEST_CASE_SUCCESS_FOURTH
import lotto.TestCaseArguments.CHECK_LOTTO_TEST_CASE_SUCCESS_SECOND
import lotto.TestCaseArguments.CHECK_LOTTO_TEST_CASE_SUCCESS_THIRD
import lotto.TestCaseArguments.CLASSIFY_LOTTO_TEST_CASE_FAIL_BONUS_NOT_INIT
import lotto.TestCaseArguments.CLASSIFY_LOTTO_TEST_CASE_FAIL_LOTTO_LIST_NOT_INIT
import lotto.TestCaseArguments.CLASSIFY_LOTTO_TEST_CASE_SUCCESS
import lotto.TestCaseArguments.SUM_LOTTO_TEST_CASE_SUCCESS
import lotto.exception.IllegalStateException
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoManagerTest {
    lateinit var lottoManager: LottoManager

    @BeforeEach
    fun setUp() {
        lottoManager = LottoManager()
    }

    @Nested
    @DisplayName("입력된 금액을 로또 개수로 바꿔주는 메서드 테스트")
    inner class GetMoneyToCountTest {

        @ParameterizedTest
        @CsvSource("1000, 1", "230000, 230", "384173000, 384173")
        fun success(money: Int, output: Int) {
            val result = lottoManager.getMoneyToCount(money)
            assertEquals(output, result)
        }

        // 잘못된 금액은 Input 할때 처리하므로 state 미초기화 오류만 체크
        @ParameterizedTest
        @CsvSource("-1")
        fun fail(input: Int) {
            assertThrows<IllegalStateException> {
                lottoManager.getMoneyToCount(input)
            }
        }
    }

    @Nested
    @DisplayName("로또를 생성하는 메서드 테스트")
    inner class GenerateLottoTest {

        @Test
        fun success() {
            assertRandomUniqueNumbersInRangeTest(
                { lottoManager.generateLotto() },
                listOf(8, 21, 23, 41, 42, 43),
                listOf(3, 5, 11, 16, 32, 38),
                listOf(7, 11, 16, 35, 36, 44),
                listOf(1, 8, 11, 31, 41, 42),
                listOf(13, 14, 16, 38, 42, 45),
                listOf(7, 11, 30, 40, 42, 43),
                listOf(2, 13, 22, 32, 38, 45),
                listOf(1, 3, 5, 14, 22, 45),
            )
        }
    }

    @Nested
    @DisplayName("로또들을 분류하는 메서드 테스트")
    inner class ClassifyLottoTest {

        @ParameterizedTest
        @MethodSource("lotto.model.LottoManagerTest#getClassifyLottoArgumentSuccess")
        fun success(lottoList: List<Lotto>, winningLotto: Lotto, bonusNumber: Int, returnMap: Map<LottoRank, Int>) {
            val result = lottoManager.classifyLotto(lottoList, winningLotto, bonusNumber)
            assertEquals(result, result)
        }

        // 보너스 번호가 초기화 되지 않았을 때, 로또가 초기화 되지 않았을 때
        @ParameterizedTest
        @MethodSource("lotto.model.LottoManagerTest#getClassifyLottoArgumentFail")
        fun fail(lottoList: List<Lotto>, winningLotto: Lotto, bonusNumber: Int, returnMap: Map<LottoRank, Int>) {
            assertThrows<IllegalStateException> {
                lottoManager.classifyLotto(lottoList, winningLotto, bonusNumber)
            }
        }
    }

    @Nested
    @DisplayName("로또를 당첨 로또와 비교해 등급을 반환하는 메서드 테스트")
    inner class CheckLottoTest {

        @ParameterizedTest
        @MethodSource("lotto.model.LottoManagerTest#getCheckLottoArgumentSuccess")
        fun success(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int, lottoRank: LottoRank) {
            val result = lottoManager.checkLotto(lotto, winningLotto, bonusNumber)
            assertEquals(result, lottoRank)
        }

        @ParameterizedTest
        @MethodSource("lotto.model.LottoManagerTest#getCheckLottoArgumentFail")
        fun fail(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int, lottoRank: LottoRank) {
            assertThrows<IllegalStateException> {
                lottoManager.checkLotto(lotto, winningLotto, bonusNumber)
            }
        }
    }

    @Nested
    @DisplayName("로또 등급별 Map을 보고 상금을 반환하는 메서드 테스트")
    inner class SumLottoTest {

        @ParameterizedTest
        @MethodSource("lotto.model.LottoManagerTest#getSumLottoArgumentSuccess")
        fun success(lottoMap: Map<LottoRank, Int>, output: Long) {
            val result = lottoManager.sumLotto(lottoMap)
            assertEquals(result, output)
        }
    }

    @Nested
    @DisplayName("상금과 로또 개수를 수익률로 반환하는 메서드 테스트")
    inner class CalculateProfitRateTest {

        @ParameterizedTest
        @CsvSource("8, 5000, 62.5", "1000, 2064725000, 206472.5", "1000000, 408460000, 40.8")
        fun success(count: Int, reward: Long, output: Double) {
            val result = lottoManager.calculateProfitRate(count, reward)
            assertEquals(output, result)
        }
    }

    companion object {

        @JvmStatic
        fun getClassifyLottoArgumentSuccess(): Stream<Arguments> = Stream.of(
            CLASSIFY_LOTTO_TEST_CASE_SUCCESS
        )

        @JvmStatic
        fun getClassifyLottoArgumentFail(): Stream<Arguments> = Stream.of(
            CLASSIFY_LOTTO_TEST_CASE_FAIL_BONUS_NOT_INIT,
            CLASSIFY_LOTTO_TEST_CASE_FAIL_LOTTO_LIST_NOT_INIT,
        )

        @JvmStatic
        fun getCheckLottoArgumentSuccess(): Stream<Arguments> = Stream.of(
            CHECK_LOTTO_TEST_CASE_SUCCESS_FIRST,
            CHECK_LOTTO_TEST_CASE_SUCCESS_SECOND,
            CHECK_LOTTO_TEST_CASE_SUCCESS_THIRD,
            CHECK_LOTTO_TEST_CASE_SUCCESS_FOURTH,
            CHECK_LOTTO_TEST_CASE_SUCCESS_FIFTH,
        )

        @JvmStatic
        fun getCheckLottoArgumentFail(): Stream<Arguments> = Stream.of(
            CHECK_LOTTO_TEST_CASE_FAIL_BONUS_NOT_INIT
        )

        @JvmStatic
        fun getSumLottoArgumentSuccess(): Stream<Arguments> = Stream.of(
            SUM_LOTTO_TEST_CASE_SUCCESS
        )
    }
}