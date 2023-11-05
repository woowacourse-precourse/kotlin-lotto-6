package lotto.ui

import lotto.ui.viewmodel.LottoViewModel
import lotto.utils.CommonConst
import lotto.utils.Exceptions

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        Exceptions.validateDuplicates(numbers)
    }

    fun startLottoDraw(bonusNumber: Int, viewModel: LottoViewModel) {
        //사용자에게 최종 통계 출력
        viewModel.checkLottoStatistics(numbers, bonusNumber).also {
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_3_MATCHES.format(it.fifthPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_4_MATCHES.format(it.fourthPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES.format(it.thirdPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES_BONUS.format(it.secondPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_6_MATCHES.format(it.firstPrizeCount))
            println(CommonConst.MESSAGE_TOTAL_PRIZE_RATE.format(it.totalPrizeRate) + CommonConst.MESSAGE_TOTAL_PRIZE_RATE_THE_REST)
        }
    }
}
