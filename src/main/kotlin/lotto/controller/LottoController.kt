package lotto.controller

import lotto.model.LottoService

class LottoController {
    private val lottoService = LottoService
    private lateinit var purchasedLottoList: List<List<Int>>
    private lateinit var winningNumber: List<Int>
    private var bonusNumber: Int = NOT_SET

    fun start() {
        // TODO 로또 추첨 로직 구현
        buyLotto()
    }

    fun buyLotto() {

    }

    companion object {
        private const val NOT_SET = -1
    }
}