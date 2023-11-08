package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoNumber
import lotto.model.Lotto

class UserLottosGenerator : LottosGenerator {
    private val lottoNumber = LottoNumber

    override fun generate(cnt: Int) : List<Lotto> {
        return (0 until cnt).map {
            Lotto(Randoms.pickUniqueNumbersInRange(lottoNumber.MIN_NUM, lottoNumber.MAX_NUM, lottoNumber.LOTTO_NUM_CNT).sorted())
        }
    }
}
