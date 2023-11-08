package lotto.Model

import lotto.Constants.InputLottoNumsException
import lotto.Constants.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6){
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_6NUMBERS)
        }
        require(numbers.distinct().size == 6){
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_ISDUPLICATED)
        }
        require(numbers.all { it in 1..45 }){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
        }
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
}

