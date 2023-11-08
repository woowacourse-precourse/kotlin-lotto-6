package lotto.util

import lotto.util.Validation.validateBonusNumber
import lotto.util.Validation.validatePurchaseAmount
import lotto.util.Validation.validateWinningNumbers
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.IllegalArgumentException

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "anc", "102"])
    fun `구매 금액이 알맞은 입력이 아니면 예외 발생`(amount: String) {
        assertThrows<IllegalArgumentException> {
            validatePurchaseAmount(amount)
        }
    }

    @ParameterizedTest
    @MethodSource("blankNumbers")
    fun `로또 번호에 입력을 하지 않으면 예외 발생`(winningNumbers: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateWinningNumbers(winningNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("inputWrongLengthNumbers")
    fun `로또 번호에 6개의 숫자 입력을 하지 않으면 예외 발생`(winningNumbers: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateWinningNumbers(winningNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("inputWrongRangeNumbers")
    fun `로또 번호에 1~45의 숫자 입력을 하지 않으면 예외 발생`(winningNumbers: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateWinningNumbers(winningNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("inputSameNumbers")
    fun `로또 번호에 중복되는 숫자를 입력하면 예외 발생`(winningNumbers: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateWinningNumbers(winningNumbers)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "anc", "102","5"])
    fun `보너스 번호에 알맞은 입력이 아니면 예외 발생`(bonusNumber: String) {
        assertThrows<IllegalArgumentException> {
            val winningNumbers = listOf(1,2,3,4,5)

            validateBonusNumber(winningNumbers,bonusNumber)
        }
    }

    companion object {
        @JvmStatic
        fun blankNumbers() = listOf(
            Arguments.of(listOf(""))
        )

        @JvmStatic
        fun inputWrongLengthNumbers() = listOf(
            Arguments.of(listOf("1", "2", "3", "4", "5")),
            Arguments.of(listOf("11", "22", "33", "44", "35"))
        )

        @JvmStatic
        fun inputWrongRangeNumbers() = listOf(
            Arguments.of(listOf("0", "46", "302", "49", "65")),
            Arguments.of(listOf("111", "22", "33", "44", "45"))
        )

        @JvmStatic
        fun inputSameNumbers() = listOf(
            Arguments.of(listOf("1", "2", "3", "3", "5")),
            Arguments.of(listOf("11", "22", "22", "35", "35"))
        )
    }


}