package lotto.domain

import lotto.constant.LottoConstant

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstant.LOTTO_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in LottoConstant.LOTTO_MIN..LottoConstant.LOTTO_MAX }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == LottoConstant.LOTTO_SIZE) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}