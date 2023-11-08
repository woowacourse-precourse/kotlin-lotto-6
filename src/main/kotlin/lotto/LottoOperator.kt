package lotto

class LottoOperator {
    private var purchasingLottos = PurchasedLottos()
    private var comparingLottoNumber = CompareLottoNumber(purchasingLottos)
    private var printResult = PrintResult(purchasingLottos)

    fun lottoRun() {
        purchasingLottos.purchasingLotto()
        comparingLottoNumber.compareWinningLottoAndPurchasedLotto()
        printResult.printResult()
    }
}