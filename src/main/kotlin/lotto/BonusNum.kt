package lotto

class BonusNum(private val bonusNum: Int) {;
    init {
        require(bonusNum in 1..45) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}
    }

    fun getBonusNum(): Int {
        return bonusNum
    }
}