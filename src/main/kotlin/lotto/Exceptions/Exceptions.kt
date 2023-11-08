package lotto.Exceptions

import lotto.Constants.InputBonusNumException
import lotto.Controller.LottoController
import lotto.Model.LottoGameModel
import lotto.Constants.InputLottoNumsException
import lotto.Constants.LottoException
import lotto.Model.Lotto

object Exceptions {

    fun howManyBuyLottoIsValid(lottoPrice: String?): Int {
        try {
            val price = lottoPrice!!.toInt()
            checkHowManyBuyLottoBy1000(price)
            return price / 1000

        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(LottoException.BUY_LOTTO_PRICE_INVALIDATE_NUMBER)
        }
    }

    private fun checkHowManyBuyLottoBy1000(input: Int){
        if (input % 1000 != 0) {
            throw IllegalArgumentException(LottoException.BUY_LOTTO_PRICE_1000)
        }
    }

    fun checkInputLottoNumbersAreValid(winningNumbers : String?) : Lotto =
        try {
            parseLottoNumbers(winningNumbers!!)
        } catch (e:NumberFormatException){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_INVALID_TYPE)
        }

    fun checkInputLottoBonusNumberIsValid(inputBonusNumber : String?, inputLottoNumber : Lotto): Int {
        try{
            val bonusNumber = inputBonusNumber!!.toInt()
            checkInputValidRange(bonusNumber)
            checkLottoAndBonusSame(bonusNumber,inputLottoNumber)
            return bonusNumber
        }catch (e :NumberFormatException){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_INVALID_TYPE)
        }
    }

    private fun checkLottoAndBonusSame(bonusNumber: Int, inputLottoNumber: Lotto){
        if(inputLottoNumber.getLottoNumbers().contains(bonusNumber)){
            throw IllegalArgumentException(InputBonusNumException.INPUT_BONUS_ISDUPLICATED)
        }
    }

    private fun checkInputNull(input: String?) {
        input ?: throw IllegalArgumentException(LottoException.INPUT_NULL)
    }

    private fun checkInputSizeIs6(input: List<String>) {
        if (input.size != 6) {
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_6NUMBERS)
        }
    }

    private fun checkInputIsDistinct(lottoNumbers : List<Int>){
        if (lottoNumbers.distinct().size != 6) {
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_ISDUPLICATED)
        }
    }

    private fun checkInputValidRange(input:Int){
        if(input <1 || input > 45){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
        }
    }

    private fun parseLottoNumbers(input: String): Lotto {
        checkInput(input)
        val numbers = splitAndFilterNumbers(input)
        checkSizeAndDistinct(numbers)
        return Lotto(createLottoNumbers(numbers))
    }

    private fun checkInput(input: String) {
        checkInputNull(input)
    }

    private fun splitAndFilterNumbers(input: String): List<String> {
        val numbers = input.split(",").map { it.trim() }.filter { it.isNotEmpty() }
        checkInputSizeIs6(numbers)
        return numbers
    }

    private fun checkSizeAndDistinct(numbers: List<String>) {
        checkInputSizeIs6(numbers)
        val lottoNumbers = createLottoNumbers(numbers)
        checkInputIsDistinct(lottoNumbers)
    }

    private fun createLottoNumbers(numbers: List<String>): List<Int> {
        return numbers.map { it.toInt() }
    }

}
