package lotto.createlotto

import lotto.lotto.Lotto
import lotto.consts.ErrorStringRes

class BaseCreateLotto(private vararg val numbers: List<Int>) : CreateLottoInterface {
    private var index = 0
    override fun getLotto(): Lotto {
        require(index < numbers.size){
            ErrorStringRes.BASE_CREATE_LOTTO_OUT_OF_RANGE
        }

        return Lotto(numbers[index++].sorted())
    }

}