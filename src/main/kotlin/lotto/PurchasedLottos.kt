package lotto

class PurchasedLottos {
    private var inputManager = InputManager()
    private var purchasedLottos = mutableListOf<Lotto>()
    private var decidePurchasedLottoNumber = DecidePurchasedLottoNumber()
    private var lottoCount: Int = IDX_ZERO
    private var bonusNumber = inputManager.getBonusNumber()

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
        println()
    }

    private fun calculateLottoCount(): Int = inputManager.playerInsertMoney() / ONE_LOTTO_PRICE

    fun getWinning() = inputManager.getWinningNumber()

    fun getInputManager() = inputManager

    fun getPurchasedLottos() = purchasedLottos
    fun getBonusNumber() = bonusNumber
}