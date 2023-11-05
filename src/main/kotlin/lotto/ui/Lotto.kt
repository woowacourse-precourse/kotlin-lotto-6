package lotto.ui

import lotto.data.repository.LottoRepositoryImpl
import lotto.ui.repository.LottoRepository
import lotto.ui.viewmodel.LottoViewModel
import lotto.utils.CommonConst

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun startLottoDraw(bonusNumber: Int, viewModel: LottoViewModel) {

        viewModel.checkLottoStatistics(numbers,bonusNumber).also {
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_3_MATCHES.format(it.fifthPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_4_MATCHES.format(it.fourthPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES.format(it.thirdPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_5_MATCHES_BONUS.format(it.secondPrizeCount))
            println(CommonConst.MESSAGE_LOTTO_WINNING_DETAILS_6_MATCHES.format(it.firstPrizeCount))
            println(CommonConst.MESSAGE_TOTAL_PRIZE_RATE.format(it.totalPrizeRate)+CommonConst.MESSAGE_TOTAL_PRIZE_RATE_THE_REST)
        }
    }
}
