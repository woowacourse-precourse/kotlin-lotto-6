package lotto

import camp.nextstep.edu.missionutils.Randoms
import client.Client

class LottoServer {
    private val client = Client()
    private val lottoList = mutableListOf<Lotto>()
    fun start(){
        val count = client.inputBuyMoneyToCount()
        createLottoRepeatByCount(count)
    }

    private fun createLottoRepeatByCount(count: Int) {
        repeat(count){
            val lotto = createLotto()
            insertLottoToList(lotto)
        }
    }

    private fun insertLottoToList(lotto: Lotto) {
        lottoList.add(lotto)
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}