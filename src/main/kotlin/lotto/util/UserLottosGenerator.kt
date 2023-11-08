package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.util.LottosGenerator.Companion.MAX_NUM
import lotto.util.LottosGenerator.Companion.MIN_NUM

class UserLottosGenerator : LottosGenerator {
    override fun generate(cnt: Int) : List<Lotto> {
        return (0 until cnt).map {
            Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUM_CNT).sorted())
        }
    }

    companion object {
        const val LOTTO_NUM_CNT = 6
    }
}
