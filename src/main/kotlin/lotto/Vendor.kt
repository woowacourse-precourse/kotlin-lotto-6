package lotto

class Vendor {
    private val inputManager = InputManager()


    fun lottoNum(): Int {

        val money = inputManager.inputMoney()
        return money.toInt() / 1000
    }
}