package lotto

class Bonus(private val number: Int) {

    init {

    }

    fun getNumber() = number

    companion object {
        const val INVALID_NUMBER_RANGE_ERROR_MESSAGE =
            "보너스 번호는 ${Lotto.MIN_NUMBER}에서 ${Lotto.MAX_NUMBER} 사이여야 합니다."
    }
}