package lotto.domain

class Consumer() {
    private val myManager = LottoManager()

    fun purchaseLotto(numberTimes: Int) {
        for (i in 1..numberTimes) {
            myManager.generateLotto()
        }
    }

    fun getManager(): LottoManager {
        return myManager
    }
}