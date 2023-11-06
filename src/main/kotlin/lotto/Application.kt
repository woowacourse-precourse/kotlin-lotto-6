package lotto

fun main() {
    val player = Player()
    val amount = player.inputPurchaseAmount()
    player.calculateLottoGenerateCount(amount)
}



