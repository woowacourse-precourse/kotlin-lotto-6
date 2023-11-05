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
        val lottoNumberInput = inputLottoNumber()
        // 결과 확인용 println(lottoNumberInput)
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
        println()
    }

    private fun generateOneLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun addLotto(oneLotto: List<Int>) {
        lottoList.add(oneLotto)
    }

    private fun inputLottoNumber(): List<Int> {
        while (true) {
            try {
                val lottoNumberInput = inputView.validateLottoNumberInput()
                val splitLottoNumbers = inputView.validateLottoNumber(lottoNumberInput)
                inputView.validateLottoSize(splitLottoNumbers)
                val intLottoNumbers = inputView.validateLottoRange(splitLottoNumbers)
                inputView.validateLottoRepeat(intLottoNumbers)
                return intLottoNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}