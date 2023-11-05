package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.model.LottoWinningNumber
import lotto.data.model.UserLottoState

object GameUtils {
    
    // 6자리 랜덤번호 생성
    private fun generateLottoNumbers(): List<Int> {
        val num = Randoms.pickUniqueNumbersInRange(
            CommonConst.GENERATE_LOTTO_NUMBERS_MIN,
            CommonConst.GENERATE_LOTTO_NUMBERS_MAX,
            CommonConst.GENERATE_LOTTO_NUMBERS_COUNT
        )
        return sortLottoNumbers(num)
    }

    // 오름차순 정렬 함수
    private fun sortLottoNumbers(input: List<Int>): List<Int> {
        return input.sorted()
    }

}