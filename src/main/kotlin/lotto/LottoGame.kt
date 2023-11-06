package lotto

class LottoGame(private val purchaseAmount: Int) {
    init {
        require(purchaseAmount % 1000 == 0) {"[ERROR]"}
    }
}