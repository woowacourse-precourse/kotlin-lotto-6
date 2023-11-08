package lotto

class PurchasedLottoList {
    private var inputManager = InputManager()
    private var purchasedLottoList = mutableListOf<Lotto>()
    private var decidePurchasedLottoNumber = DecidePurchasedLottoNumber()
    private var lottoCount: Int = 0

    fun purchasingLotto() {
        initLottoCount()
        makePurchasedLottoListInstance()
        printPurchasedLottoList()
        inputManager.playerInputNumbers()
    }

    private fun initLottoCount() {
        lottoCount = calculateLottoCount()
    }

    private fun makePurchasedLottoListInstance() {
        for(i in 0 until lottoCount) {
            val temporalLotto = Lotto(decidePurchasedLottoNumber.randomLottoNumberGenerator())
            purchasedLottoList.add(temporalLotto)
        }
    }

    private fun printPurchasedLottoList() {
        for(i in 0 until purchasedLottoList.size) {
            println("${purchasedLottoList[i].getNumbersList()}")
        }
    }

    private fun calculateLottoCount(): Int = inputManager.playerInsertMoney() / ONE_LOTTO_PRICE
}