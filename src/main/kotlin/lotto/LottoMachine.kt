package lotto

class LottoMachine {
    private val lottoDraws = mutableListOf<Lotto>()
    private var winningNumbers = setOf<Int>()
    private var bonusNumber = 0

    fun generateLottoDraws(count: Int) {
        lottoDraws.clear() // 이전 추첨 번호들을 삭제
        repeat(count) {
            lottoDraws.add(Lotto(LottoGenerator.generateNumbers()))
        }
    }

    fun inputWinningNumbers(winningNumbers: Set<Int>) {
        require(winningNumbers.size == 6) { "Must have exactly 6 winning numbers." }
        this.winningNumbers = winningNumbers
    }

    fun inputBonusNumber(bonusNumber: Int) {
        require(bonusNumber in 1..45) { "Bonus number must be between 1 and 45." }
        this.bonusNumber = bonusNumber
    }

    fun calculateResults(): Map<String, Int> {
        val results = mutableMapOf(
            "3개 일치 (5,000원)" to 0,
            "4개 일치 (50,000원)" to 0,
            "5개 일치 (1,500,000원)" to 0,
            "5개 일치, 보너스 볼 일치 (30,000,000원)" to 0,
            "6개 일치 (2,000,000,000원)" to 0
        )

        println("lotto: $lottoDraws")
        lottoDraws.forEach { lotto ->
            val matchCount = lotto.getNumbers().intersect(winningNumbers).size
            when (matchCount) {
                6 -> results["6개 일치 (2,000,000,000원)"] = results["6개 일치 (2,000,000,000원)"]!! + 1
                5 -> if (lotto.getNumbers().contains(bonusNumber)) {
                    results["5개 일치, 보너스 볼 일치 (30,000,000원)"] = results["5개 일치, 보너스 볼 일치 (30,000,000원)"]!! + 1
                } else {
                    results["5개 일치 (1,500,000원)"] = results["5개 일치 (1,500,000원)"]!! + 1
                }
                4 -> results["4개 일치 (50,000원)"] = results["4개 일치 (50,000원)"]!! + 1
                3 -> results["3개 일치 (5,000원)"] = results["3개 일치 (5,000원)"]!! + 1
            }
        }
        return results
    }

    fun setLottoDraws(lottoDraws: List<Lotto>) {
        this.lottoDraws.clear()
        this.lottoDraws.addAll(lottoDraws)
    }
}
