package lotto.controller

class LottoController {
    private lateinit var purchasedLottoList: List<List<Int>>
    private lateinit var winningNumber: List<Int>
    private var bonusNumber: Int = NOT_SET

    fun start() {
        // TODO 로또 추첨 로직 구현
    }

    companion object {
        private const val NOT_SET = -1
    }
}