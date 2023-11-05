package lotto.model

class Lotteries(private val _lotteries: List<Lotto>) {

    fun printLotteries() {
        _lotteries.forEach {
            it.printLotto()
        }
    }
}