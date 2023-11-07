package lotto.Exceptions

import lotto.Controller.LottoController
import lotto.Controller.checkValidationBonusLottoNumbers
import lotto.Controller.howManyBuyLotto
import lotto.Model.LottoGameModel
import lotto.Utils.InputLottoNumsException
import lotto.Utils.LottoException

object Exceptions {

    fun checkHowManyBuyLottoIsValid(lottoPrice : String?){
        if (lottoPrice != null) {
            val numberOfLottoTickets = howManyBuyLotto(lottoPrice)
            println("\n$numberOfLottoTickets 개를 구매했습니다.")
            LottoController.lottoGameModel = LottoGameModel(numberOfLottoTickets)
        }
    }

    fun checkInputLottoNumbersAreValid(winningNumbers : String?){
        if (winningNumbers != null) {
            val parsedWinningNumbers = parseLottoNumbers(winningNumbers)
            LottoController.lottoGameModel?.setWinningNumbers(parsedWinningNumbers)
        }
    }

    fun checkInputLottoBonusNumberIsValid(bonusNumber : String?){
        if (bonusNumber != null) {
            val bonus = checkValidationBonusLottoNumbers(bonusNumber)
            LottoController.lottoGameModel?.setBonusNumber(bonus)
        }
    }

    fun checkInputNull(input: String?){
        if (input == null) {
            throw IllegalArgumentException(LottoException.INPUT_NULL)
        }
    }

    fun checkInputSizeIs6(input : List<String>){
        if (input.size != 6) {
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_6NUMBERS)
        }
    }

    fun checkInputIsDistinct(lottoNumbers : List<Int>){
        if (lottoNumbers.distinct().size != 6) {
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_ISDUPLICATED)
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

    fun checkInputValidRange(input:Int){
        if(input <1 || input > 45){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
        }
    }
}