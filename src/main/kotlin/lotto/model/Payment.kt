package lotto.model

import lotto.model.seller.Money
import lotto.model.seller.toMoney
import lotto.model.validator.PaymentValidation
import lotto.model.validator.PaymentValidator

class Payment private constructor(lottoPrice: Money, val cost: Money) {

    val purchase: Int = cost.value / lottoPrice.value

    companion object {
        fun from(input: String, lottoPrice: Int, validator: PaymentValidator = PaymentValidator()): Payment {
            validator.validate(PaymentValidation(input, lottoPrice))

            val price = lottoPrice.toMoney()
            val cost = input.toInt().toMoney()

            return Payment(price, cost)
        }
    }
}