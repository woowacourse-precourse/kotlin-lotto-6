package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoInitializer {
    companion object{
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }

    fun init(){
        println("로또번호 생성")
    }

    fun makeLottoNumber(): List<Int>{
        var lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
            LOTTO_SIZE)
        return lotto
    }

    fun dividePriceByThousand(price: Int): Int{
        val amountOfLotto = price / 1000
        return amountOfLotto
    }
}