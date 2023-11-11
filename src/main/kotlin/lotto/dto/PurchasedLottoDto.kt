package lotto.dto

class PurchasedLottoDto (private val numbers : List<Int>, private val winPrize: Int, private val winRank: Int) {
    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    fun getWinPrize(): Int {
        return winPrize
    }

    fun getWinRank(): Int {
        return winRank
    }
}