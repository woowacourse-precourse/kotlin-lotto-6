package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    private val inputView = InputView()
    private val outView = OutputView()
    private val lottoList = mutableListOf<List<Int>>()

    fun run() {
        val priceAmount = inputPriceAmount()
        println()
        val lottoCount = inputView.calculateCount(priceAmount)
        generateAllLotto(lottoCount)
    }

    private fun inputPriceAmount(): Int {
        while (true) {
            try {
                val priceAmountInput = inputView.validatePriceAmount()
                val intPriceAmount = inputView.validatePriceInt(priceAmountInput)
                val priceAmount = inputView.validatePriceRange(intPriceAmount)
                return inputView.validatePriceUnit(priceAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateAllLotto(lottoCount: Int) {
        for (i in 0..<lottoCount) {
            val oneLotto = generateOneLotto()
            val lotto = Lotto(oneLotto)
            val sortedLotto = lotto.sortNumbers()
            addLotto(sortedLotto)
            outView.printOneLotto(sortedLotto)
        }
    }

    private fun generateOneLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun addLotto(oneLotto: List<Int>) {
        lottoList.add(oneLotto)
    }
}