package lotto

enum class BonusNum(private val bonusNum: Int) {;
    init {
        require(bonusNum in 1..45) { "1 ~ 45 범위 밖의 숫자가 존재합니다." }
    }
}