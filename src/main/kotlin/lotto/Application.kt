package lotto

fun main() {
    val cnt = LottoPurchase().purchaseCheck()
    val lottoNumbers = LottoPick().randomLotto(cnt)
    val prizeNumber = LottoPick().pickNumber()
    val bonusNumber = LottoPick().bonusPickNumber()
}
