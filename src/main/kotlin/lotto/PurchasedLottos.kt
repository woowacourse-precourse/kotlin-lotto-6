package lotto

class PurchasedLottos {
    private var inputManager = InputManager()
    private var purchasedLottos = mutableListOf<Lotto>()
    private var decidePurchasedLottoNumber = DecidePurchasedLottoNumber()
    private var lottoCount: Int = IDX_ZERO

    fun purchasingLotto() {
        initLottoCount()
        makePurchasedLottos()
        printPurchasedLottoList()
        inputManager.playerInputNumbers()
    }

    private fun initLottoCount() {
        lottoCount = calculateLottoCount()
    }

    private fun makePurchasedLottos() {
        for (i in IDX_ZERO until lottoCount) {
            val temporalLotto = Lotto(decidePurchasedLottoNumber.randomLottoNumberGenerator())
            purchasedLottos.add(temporalLotto)
        }
    }

    private fun printPurchasedLottoList() {
        for (i in IDX_ZERO until purchasedLottos.size) {
            println("${purchasedLottos[i].getNumbers()}")
        }
    }

    private fun calculateLottoCount(): Int = inputManager.playerInsertMoney() / ONE_LOTTO_PRICE

    fun getWinning() = inputManager.getWinningNumber()

    fun getPurchasedLottos() = purchasedLottos
}