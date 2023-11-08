package lotto.utils

import lotto.constants.ExceptionMessage
import lotto.constants.ExceptionMessage.NOT_MULTIPLE_OF_LOTTO_TICKET_PRICE
import lotto.constants.ExceptionMessage.WRONG_PURCHASE_MONEY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoPurchaseExceptionHandlerTest {
  @DisplayName("validateInputPurchaseMoney 메서드 테스트 - 정상적인 입력")
  @ParameterizedTest
  @MethodSource("goodInputPurchaseMoneyTest")
  fun goodInputPurchaseMoneyTest(inputPurchaseMoney: String, expected: Long) {
    val actual = LottoPurchaseExceptionHandler.validateInputPurchaseMoney(inputPurchaseMoney)

    assertThat(actual).isEqualTo(expected)
  }

  @DisplayName("validateInputPurchaseMoney 메서드 테스트 - 비정상적인 입력")
  @ParameterizedTest
  @MethodSource("badInputPurchaseMoneyTest")
  fun badInputPurchaseMoneyTest(inputPurchaseMoney: String, message: String) {
    val exception = assertThrows<IllegalArgumentException>(message) {
      LottoPurchaseExceptionHandler.validateInputPurchaseMoney(inputPurchaseMoney)
    }
    assertThat(message).isEqualTo(exception.message)
  }

  companion object {
    @JvmStatic
    fun goodInputPurchaseMoneyTest() = listOf(
      Arguments.of("8000", 8000L),
      Arguments.of("0", 0L),
      Arguments.of("   7000 ", 7000L),
      Arguments.of(" 8,000", 8000L),
      Arguments.of(" 8 000 000 000", 8_000_000_000L),
      Arguments.of("8_000_000_000   ", 8_000_000_000L),
    )

    @JvmStatic
    fun badInputPurchaseMoneyTest() = listOf(
      Arguments.of("2000.0", WRONG_PURCHASE_MONEY),
      Arguments.of(",,,", WRONG_PURCHASE_MONEY),
      Arguments.of("이천원", WRONG_PURCHASE_MONEY),
      Arguments.of("2.000.000", WRONG_PURCHASE_MONEY),
      Arguments.of("2/000/000", WRONG_PURCHASE_MONEY),
      Arguments.of("-2000", WRONG_PURCHASE_MONEY),
      Arguments.of("2700", NOT_MULTIPLE_OF_LOTTO_TICKET_PRICE),
    )
  }
}