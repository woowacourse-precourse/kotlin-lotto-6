package lottoViewModel

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class CreateNumbers {
    fun getLottoList(purchaseNumber: Int): List<Lotto> {
        val tmpLottoList = mutableListOf<Lotto>()

        for (i in 0 until purchaseNumber) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val tmpLotto = Lotto(numbers)
            tmpLottoList.add(tmpLotto)
        }
        return tmpLottoList.toList()
    }
    
}