package lotto

fun main() {
    startGame()
}
fun startGame() {
    getLottoNumbers()
}

fun getLottoNumbers() {
    val player = Controller()

    val seedMoney = player.getSeedMoney()
    val ticketNumber = player.generateLottoNumbers(seedMoney)
    val lottoNumberResults = player.getRandomLottoNumbers(ticketNumber)
    player.printRandomLottoNumbers(lottoNumberResults)
}