package lotto

class LottoProgramError {
    fun checkInputMoneyDivided1000Won(money: Int) {
        if (money % 1000 != 0) throw IllegalArgumentException()
    }
}