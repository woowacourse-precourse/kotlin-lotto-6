package lotto.model

class Lottoes(val lottoes: List<Lotto>, val inputLotto: String) {

    fun calculateQuantity(inputPrice: String): Int = inputPrice.toInt() / 1000

    fun calculateWinningResult(winningRank: WinningRank) {

    }

    fun calculateTotalProfit() {

    }
}