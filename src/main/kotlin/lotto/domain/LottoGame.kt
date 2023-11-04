package lotto.domain

import lotto.InputManager
import lotto.view.OutputView

class LottoGame {
    private val inputManager = InputManager()
    private val outputView = OutputView()
    private val lottoShop = LottoShop()
    private val lottos = mutableListOf<Lotto>()
    private var inputMoney = 0

    fun startGame() {
        inputMoney = inputManager.getInputMoney().toInt()
        setLottos()
        outputView.printNumberOfLottos(lottos)
        outputView.printLottoNumbers(lottos)
    }

    private fun setLottos() {
        repeat(inputMoney / 1000) {
            lottos.add(lottoShop.issueLotto())
        }
    }
}