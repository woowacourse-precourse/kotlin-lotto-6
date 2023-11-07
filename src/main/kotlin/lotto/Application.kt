package lotto

fun main() {
    val purchase = PurchaseAmount()
    val purchaseAmount = purchase.enterNumber()  // 구입횟수
    
    val lottos = Lottos()
    val lottosNumbers = lottos.getNumbers(purchaseAmount)  // 로또 발행
    lottos.printLottos(lottosNumbers)
}
