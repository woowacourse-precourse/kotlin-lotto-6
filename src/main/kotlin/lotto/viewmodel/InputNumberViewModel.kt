package lotto.viewmodel

import lotto.observer.InputNumberErrorListener
import lotto.observer.InputNumberListener

class InputNumberViewModel {
    lateinit var inputNumberErrorListener: InputNumberErrorListener
    lateinit var inputNumberListener: InputNumberListener
    private lateinit var lottoNumber: List<Int>
    private val inputValidator: InputValidator = InputValidator()
    private var bonusNumber: Int = 0

    fun updateLottoNumber(number: String) {
        try { checkLottoNumber(number) }
        catch (e: IllegalArgumentException) { inputNumberErrorListener.onLottoNumberError(e.message!!) }
    }

    fun updateBonusNumber(number: String) {
        try { checkBonusNumber(number) }
        catch (e: IllegalArgumentException) { inputNumberErrorListener.onBonusNumberError(e.message!!) }
    }

    private fun checkLottoNumber(number: String) {
        inputValidator.lottoNumberValidator(number)
        this.lottoNumber = number.split(",").map { it.trim().toInt() }
        inputNumberListener.inputNumberListener(this.lottoNumber)
    }

    private fun checkBonusNumber(number: String) {
        inputValidator.bonusNumberValidator(lottoNumber, number)
        this.bonusNumber = number.toInt()
        inputNumberListener.inputBonusNumberListener(this.bonusNumber)
    }
}