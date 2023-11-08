package lotto

class LottoOperator {
    private lateinit var purchasingLottos: PurchasedLottos
    private lateinit var comparingLottoNumber: CompareLottoNumber

    fun lottoRun() {
        purchasingLottos = PurchasedLottos()
        comparingLottoNumber = CompareLottoNumber(purchasingLottos)
    }

}