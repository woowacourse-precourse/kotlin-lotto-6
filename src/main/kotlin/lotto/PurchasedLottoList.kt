package lotto

class PurchasedLottoList {
    private var inputManager = InputManager()
    lateinit var purchasedLottoList : MutableList<Lotto>
    private lateinit var decideLottoNumber : DecideLottoNumber
    private var lottoCount: Int = 0

    fun initLottoCount() {
        lottoCount = calculateLottoCount()
    }

    fun makePurchasedLottoListInstance() {
        for(i in 0 until lottoCount) {
            var temporalLotto = Lotto(decideLottoNumber.randomLottoNumberGenerator())
            purchasedLottoList.add(temporalLotto)
        }
    }

    private fun calculateLottoCount(): Int = inputManager.playerInsertMoney() / ONE_LOTTO_PRICE
}