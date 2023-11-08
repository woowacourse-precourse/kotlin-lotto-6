package lotto.createlotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.consts.GameConst
import lotto.lotto.Lotto

class RandomCreateLotto : CreateLottoInterface {
    override fun getLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, GameConst.MAX_NUM, GameConst.NUM_COUNT)
        return Lotto(numbers.sorted())
    }

}