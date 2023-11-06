package lotto.model

class Lotteries(private val _lotteries: List<Lotto>) {

    fun printLotteries() {
        _lotteries.forEach {
            it.printLotto()
        }
    }

    fun compareLotteries(winningLotto: List<Int>, bonusNumber: Int): Map<Int, Int> {
        val compareResult = hashMapOf<Int, Int>()
        _lotteries.forEach {
            val rank = it.compareLotto(winningLotto, bonusNumber)
            compareResult[rank] = compareResult.getOrDefault(rank, 0) + 1
        }
        return compareResult
    }
}