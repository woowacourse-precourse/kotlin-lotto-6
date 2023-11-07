package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        require(numbers.all { it in 1..45 })
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    fun checkWinnings() {

    }
    // TODO: 추가 기능 구현
}

class LottoGameModel(howManyBuyLotto: Int) {
    val lottoList: List<Lotto>
    private var winningNumbers: List<Int>? = null
    private var bonusNumber: Int? = null

    companion object {
        var instance: LottoGameModel? = null
    }

    init {
        require(howManyBuyLotto >= 0)

        lottoList = (1..howManyBuyLotto).map {
            val lottoNumbers = createLottoNumbers()
            Lotto(lottoNumbers)
        }
    }

    fun setWinningNumbers(winningNumbers: List<Int>) {
        this.winningNumbers = winningNumbers
    }

    fun setBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }

    fun createLottoNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }

    // lottoList에 저장된 Lotto 객체의 numbers를 출력하는 메서드
    fun printLottoNumbers() {
        for (lotto in lottoList) {
            println(lotto.getLottoNumbers())
        }
    }
}