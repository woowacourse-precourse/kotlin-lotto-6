package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    private val view = View()

    fun start() {
        val payment = view.inputPayment()
        val lottos = makeLotto(payment)
        view.printLotto(lottos)
        val inputLottoNumber = view.inputLottoNumber()
        val inputBonusNumber = view.inputBonusLottoNumber()

        val prize = winningLotteryResult(lottos, inputLottoNumber, inputBonusNumber)
        val winRate = calculateWinRate(prize, lottos)

        view.printPrizeResult(prize)
        view.printWinRate(winRate)
    }

    private fun winningLotteryResult(lottos: List<Lotto>, inputLottoNumber: Lotto, inputBonusNumber: Int): Prize {
        val inputNumber = inputLottoNumber.getLottoNumbers()
        val prize = Prize()
        lottos.forEach { lotto ->
            val lottoNum = lotto.getLottoNumbers()
            val count = countMatchNumber(lottoNum, inputNumber)
            when (count) {
                6 -> prize.countPrize(Rank.FIRST_RANK)
                5 -> {
                    if (lottoNum.contains(inputBonusNumber)) {
                        prize.countPrize(Rank.SECOND_RANK)
                    } else {
                        prize.countPrize(Rank.THIRD_RANK)
                    }
                }

                4 -> prize.countPrize(Rank.FOURTH_RANK)
                3 -> prize.countPrize(Rank.FIFTH_RANK)
                else -> Rank.MISS
            }
        }
        return prize
    }

    private fun calculateWinRate(prize: Prize, lottos: List<Lotto>): Double {
        return (prize.getPrizeMoney() / (lottos.size * 1000) * 100)
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
        val num = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(num.sorted())
    }

    private fun countLotto(payment: Int): Int {
        return payment / 1000
    }
}