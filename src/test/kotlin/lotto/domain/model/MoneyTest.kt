package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    @DisplayName("Money 생성시 입력이 올바른 경우 성공적으로 Money 생성")
    fun createMoney_validateAmount_createdSuccessfully() {
        // when
        val money = Money(amount = VALID_NUMBER)

        // then
        assertThat(money.amount).isEqualTo(VALID_NUMBER)
    }

    @Test
    @DisplayName("Money 생성시 입력이 ${Money.DIVISION_AMOUNT}로 나누어 떨어지지 않을 경우 예외 발생")
    fun createMoney_amountIsNotDividableByDivisionAmount_throwIllegalArgumentException() {
        assertThatIllegalArgumentException()
            // when
            .isThrownBy { Money(amount = NOT_DIVIDABLE_NUMBER) }
            // then
            .withMessage(Money.MUST_BE_DIVIDABLE_BY_DIVISION_AMOUNT_MESSAGE) // then
    }

    @Test
    @DisplayName("Money 생성시 입력이 ${Money.MIN_MONEY_AMOUNT}보다 작은 경우 예외 발생")
    fun createMoney_amountIsLessThanMinimum_throwIllegalArgumentException() {
        assertThatIllegalArgumentException()
            // when
            .isThrownBy { Money(amount = LESS_THEN_MIN_MONEY_AMOUNT) }
            // then
            .withMessage(Money.MUST_GREATER_THAN_MIN_MONEY_MESSAGE) // then
    }

    companion object {
        const val VALID_NUMBER = Money.DIVISION_AMOUNT * 2
        const val NOT_DIVIDABLE_NUMBER = VALID_NUMBER + 100
        const val LESS_THEN_MIN_MONEY_AMOUNT = Money.MIN_MONEY_AMOUNT - 100
    }
}