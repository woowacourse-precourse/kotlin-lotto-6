package lotto.domain

data class LottoNumber(private val value: Int) {
    init {
        require(value in 1..45)
    }
}