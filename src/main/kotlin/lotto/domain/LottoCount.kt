package lotto.domain

class LottoCount(private val amount: Int) {
    fun calculate() = amount.div(1000)
}