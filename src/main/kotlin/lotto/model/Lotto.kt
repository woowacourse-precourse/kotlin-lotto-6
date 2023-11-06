package lotto.model

// 사용자 구매 로또
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
