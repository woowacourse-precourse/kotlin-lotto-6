package lotto.model

class WinningLotto(val winningNums: Lotto, val bonusNum: Int) {
    init {
        require(bonusNum in MIN_NUM..MAX_NUM) {throw IllegalArgumentException(OUT_OF_RANGE)}
        require(!winningNums.getNumbers().contains(bonusNum)) {
            throw IllegalArgumentException(IS_DUPLICATED.format(bonusNum))
        }
    }

    fun getMatchCnt(lotto: Lotto) : Int = lotto.getNumbers().count {winningNums.getNumbers().contains(it)}

    fun getMatchBonus(lotto: Lotto): Boolean = lotto.getNumbers().contains(bonusNum)

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        const val OUT_OF_RANGE = "로또 숫자는 $MIN_NUM ~ $MAX_NUM 사이의 숫자를 입력해야 합니다."
        const val IS_DUPLICATED = "당첨 번호와 보너스 번호는 중복될 수 없습니다. 중복된 번호 : %d."
    }
}
