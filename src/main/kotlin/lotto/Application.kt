package lotto

fun main() {
    try {
        val ask = Ask()
        val amount = ask.amount()
        val purchasedLotto = Purchase(amount).lottoNum()
        val winNum = ask.winNum()
        val bonusNum = ask.bonusNum(winNum)

        Statistics(amount).winLotto(purchasedLotto, winNum, bonusNum)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}