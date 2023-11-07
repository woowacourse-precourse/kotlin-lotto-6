package lotto.Exceptions

import lotto.Controller.LottoController
import lotto.Controller.howManyBuyLotto
import lotto.Model.LottoGameModel
import lotto.Utils.InputLottoNumsException
import lotto.Utils.LottoException

object Exceptions {

    fun checkHowManyBuyLottoIsValid(lottoPrice : String?){
        lottoPrice?.let {
            val numberOfLottoTickets = howManyBuyLotto(it)
            println("\n$numberOfLottoTickets 개를 구매했습니다.")
            LottoController.lottoGameModel = LottoGameModel(numberOfLottoTickets)
        }
    }

    fun checkInputLottoNumbersAreValid(winningNumbers : String?){
        winningNumbers?.let {
            val parsedWinningNumbers = parseLottoNumbers(it)
            LottoController.lottoGameModel?.setWinningNumbers(parsedWinningNumbers)
        }
    }

    fun checkInputLottoBonusNumberIsValid(bonusNumber : String?){
        bonusNumber?.let {
            val bonus = checkValidationBonusLottoNumbers(it)
            LottoController.lottoGameModel?.setBonusNumber(bonus)
        }
    }

    fun checkInputNull(input: String?) {
        input ?: throw IllegalArgumentException(LottoException.INPUT_NULL)
    }

    fun checkInputSizeIs6(input: List<String>) {
        if (input.size != 6) {
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_6NUMBERS)
        }
    }

    fun checkInputIsDistinct(lottoNumbers : List<Int>){
        if (lottoNumbers.distinct().size != 6) {
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_ISDUPLICATED)
        }
    }

    fun checkInputValidRange(input:Int){
        if(input <1 || input > 45){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
        }
    }
    fun parseLottoNumbers(input: String?): List<Int> {
        checkInputNull(input)

        val numbers = input!!.split(",").map { it.trim() }.filter { it.isNotEmpty() }

        checkInputSizeIs6(numbers)

        val lottoNumbers = numbers.map {
            try {
                val number = it.toInt()
                checkInputValidRange(number)
                number
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(LottoException.INPUT_LOTTO_INVALID_TYPE)
            }
        }

        checkInputIsDistinct(lottoNumbers)

        return lottoNumbers
    }

    fun checkValidationBonusLottoNumbers(bonusNumber: String?): Int{
        checkInputNull(bonusNumber)

        try {
            val number = bonusNumber!!.toInt()
            checkInputValidRange(number)
            return number
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_INVALID_TYPE)
        }
    }

}
