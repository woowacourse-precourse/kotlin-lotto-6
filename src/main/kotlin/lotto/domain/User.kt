package lotto.domain

import lotto.util.Exception

class User(private val price: Int, private val lottoes: List<Lotto>) {

    init {
        validate()
    }

    fun getLottoes() = lottoes

    fun getPrice() = price

    private fun validate() {
        Exception.validateUserPrice(price)
        Exception.validateUserLottoes(price, lottoes)
    }

}