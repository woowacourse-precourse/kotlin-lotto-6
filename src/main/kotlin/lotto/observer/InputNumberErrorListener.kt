package lotto.observer

interface InputNumberErrorListener {
    fun onLottoNumberError(errorMessage: String)
    fun onBonusNumberError(errorMessage: String)
}