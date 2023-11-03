package lotto

fun main() {
    val cnt = LottoMatch().purchaseCheck()
    val lottoNumbers = LottoPick().randomLotto(cnt)
    val prize = LottoPick().pickNumber()
}
