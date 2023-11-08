package lotto


fun main() {
    start()
}

fun start() {
    val total = inputPrice()
    printLottos(total)
    LottoInput.putWiningNumbers()
    LottoInput.putBonusNumber()
    LottoProfit().printResult(total, total.size)
}

fun inputPrice(): List<Lotto> {
    try {
        return LottoInput.buyLotto(Ticket().numberOfLotto)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputPrice()
    }
    return emptyList()
}

fun printLottos(total: List<Lotto>) {
    println("${total.size}개를 구매했습니다.")
    total.forEach { it.printLotto() }
}
