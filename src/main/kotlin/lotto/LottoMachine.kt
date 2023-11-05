package lotto

class LottoMachine() {
    fun calculateNumberOfLotto(price: Int): Int = price / WON_PER_LOTTO

    companion object {
        const val WON_PER_LOTTO = 1000
    }
}