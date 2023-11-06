package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    private val inputView = InputView()
    private val outView = OutputView()
    private val lottoList = mutableListOf<List<Int>>()
    private val lottoResult = LottoResult()

    fun run() {
        val priceAmount = inputPriceAmount()
        val lottoCount = inputView.calculateCount(priceAmount)
        generateAllLotto(lottoCount)
        val lottoNumberInput = inputLottoNumber()
        //println(lottoNumberInput) 결과 확인용
        val bonusNumberInput = inputBonusNumber(lottoNumberInput)
        //println(bonusNumberInput) 결과 확인용
        val lottoResultList = lottoResult.calculateResult(lottoList, lottoNumberInput, bonusNumberInput)
        //println(lottoResult) 결과 확인용
        outView.printLottoResult(lottoResultList)
        val totalPrize = lottoResult.calculateTotalPrize(lottoResultList)
        outView.printTotalProfit(priceAmount, totalPrize)
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
        for (i in 0 until lottoCount) {
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

    private fun inputBonusNumber(lottoNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumberInput = inputView.validateBonusNumberInput()
                val intBonusNumber = inputView.validateBonusNumber(bonusNumberInput)
                inputView.validateBonusNumberRange(intBonusNumber)
                inputView.validateBonusRepeat(intBonusNumber, lottoNumbers)
                return intBonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}