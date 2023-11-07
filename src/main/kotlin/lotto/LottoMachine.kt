package lotto

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.util.VisibleForTesting

class LottoMachine {
    private val view = View()

    fun start() {
        val payment = view.inputPayment()
        val lottos = makeLotto(payment.getPayment())
        view.printLotto(lottos)
        val inputLottoNumber = view.inputLottoNumber()
        val inputBonusNumber = view.inputBonusLottoNumber(inputLottoNumber)

        val prize = winningLotteryResult(lottos, inputLottoNumber, inputBonusNumber)
        val winRate = calculateWinRate(prize, lottos)

        view.printPrizeResult(prize)
        view.printWinRate(winRate)
    }

    @VisibleForTesting
    fun winningLotteryResult(lottos: List<Lotto>, inputLottoNumber: Lotto, inputBonusNumber: BonusNumber): Prize {
        val inputNumber = inputLottoNumber.getLottoNumbers()
        val prize = Prize()
        lottos.forEach { lotto ->
            val lottoNum = lotto.getLottoNumbers()
            val count = countMatchNumber(lottoNum, inputNumber)
            countPrize(count, prize, lottoNum, inputBonusNumber)
        }
        return prize
    }

    private fun countPrize(
        count: Int,
        prize: Prize,
        lottoNum: List<Int>,
        inputBonusNumber: BonusNumber,
    ) {
        when (count) {
            6 -> prize.countPrize(Rank.FIRST_RANK)
            5 -> checkBonusNumber(lottoNum, inputBonusNumber.getBonusNumber(), prize)
            4 -> prize.countPrize(Rank.FOURTH_RANK)
            3 -> prize.countPrize(Rank.FIFTH_RANK)
            else -> prize.countPrize(Rank.MISS)
        }
    }

    private fun checkBonusNumber(lottoNum: List<Int>, inputBonusNumber: Int, prize: Prize) {
        if (lottoNum.contains(inputBonusNumber)) {
            prize.countPrize(Rank.SECOND_RANK)
        } else {
            prize.countPrize(Rank.THIRD_RANK)
        }
    }

    private fun calculateWinRate(prize: Prize, lottos: List<Lotto>): Double {
        return (prize.getPrizeMoney() / (lottos.size * LOTTO_UNITS) * PERCENT)
    }

    private fun countMatchNumber(lottoNum: List<Int>, inputNumber: List<Int>): Int {
        return lottoNum.count {
            inputNumber.contains(it)
        }
    }

    private fun makeLotto(payment: Int): List<Lotto> {
        val count = countLotto(payment)
        val lotto = mutableListOf<Lotto>()
        repeat(count) {
            lotto.add(generateLotto())
        }
        return lotto
    }

    private fun generateLotto(): Lotto {
        val num = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_COUNT)
        return Lotto(num.sorted())
    }

    private fun countLotto(payment: Int): Int {
        return payment / LOTTO_UNITS
    }

    companion object {
        const val LOTTO_UNITS = 1000
        const val PERCENT = 100
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        const val LOTTO_COUNT = 6
    }
}