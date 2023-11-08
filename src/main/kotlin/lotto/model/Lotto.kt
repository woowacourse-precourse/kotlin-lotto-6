package lotto.model

import lotto.domain.LottoRule

// 사용자 구매 로또 번호
class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LottoRule.COUNT.num)
        require(numbers.toSet().size == LottoRule.COUNT.num)
        require(numbers.all { number ->
            number in LottoRule.START_INCLUSIVE.num..
                    LottoRule.END_INCLUSIVE.num
        })
    }

    fun getLottoNumbers(): List<Int> = numbers

    fun changeLottoNumbersToSet(): Set<Int> = numbers.toSet()

}
