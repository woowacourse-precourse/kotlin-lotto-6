package lotto.domain

import lotto.InputManager

class LottoGame {
    private val inputManager = InputManager()
    private val lottoShop = LottoShop()
    private val lottos = mutableListOf<Lotto>()
    private var inputMoney = 0

    fun startGame() {
        inputMoney = inputManager.getInputMoney().toInt()
        setLottos()
    }

    private fun setLottos() {
        repeat(inputMoney / 1000) {
            lottos.add(lottoShop.issueLotto())
        }
    }
}