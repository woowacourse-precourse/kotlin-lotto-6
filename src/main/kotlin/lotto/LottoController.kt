package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    private val inputView = InputView()
    private val outView = OutputView()
    private val validator = Validator()
    private val lottoList = mutableListOf<List<Int>>()
    private val lottoResult = LottoResult()

    fun run() {
        val purchaseAmount = inputPurchaseAmount()
        val lottoCount = calculateCount(purchaseAmount)
        outView.printLottoCount(lottoCount)
        generateAllLotto(lottoCount)
        val lottoNumberInput = inputLottoNumber()
        val bonusNumberInput = inputBonusNumber(lottoNumberInput)
        val lottoResultList = lottoResult.calculateResult(lottoList, lottoNumberInput, bonusNumberInput)
        outView.printLottoResult(lottoResultList)
        val totalPrize = lottoResult.calculateTotalPrize(lottoResultList)
        outView.printTotalProfit(purchaseAmount, totalPrize)
    }

    private fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmountInput = inputView.purchaseAmountInput()
                val purchaseAmountString = validator.validatePurchaseAmount(purchaseAmountInput)
                val intPurchaseAmount = validator.validatePurchaseInt(purchaseAmountString)
                val purchaseAmount = validator.validatePurchaseRange(intPurchaseAmount)
                return validator.validatePriceUnit(purchaseAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun calculateCount(purchaseAmount: Int): Int {
        return purchaseAmount / Validator.PURCHASE_AMOUNT_UNIT
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
        return Randoms.pickUniqueNumbersInRange(
            Constant.LOTTO_NUMBER_START,
            Constant.LOTTO_NUMBER_END,
            Constant.LOTTO_NUMBER_SIZE
        )
    }

    private fun addLotto(oneLotto: List<Int>) {
        lottoList.add(oneLotto)
    }

    private fun inputLottoNumber(): List<Int> {
        while (true) {
            try {
                val lottoNumberInput = inputView.lottoNumbersInput()
                val lottoNumber = validator.validateLottoNumberInput(lottoNumberInput)
                val splitLottoNumbers = validator.validateLottoNumber(lottoNumber)
                validator.validateLottoSize(splitLottoNumbers)
                val intLottoNumbers = validator.validateLottoRange(splitLottoNumbers)
                validator.validateLottoRepeat(intLottoNumbers)
                return intLottoNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(lottoNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumberInput = inputView.bonusNumberInput()
                val bonusNumber = validator.validateBonusNumberInput(bonusNumberInput)
                val intBonusNumber = validator.validateBonusNumber(bonusNumber)
                validator.validateBonusNumberRange(intBonusNumber)
                validator.validateBonusRepeat(intBonusNumber, lottoNumbers)
                return intBonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}