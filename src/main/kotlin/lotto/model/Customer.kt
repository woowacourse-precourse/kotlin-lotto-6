package lotto.model

import lotto.utils.Constants.INITIALIZE_NUMBER

class Customer(
    private var pay: Int = INITIALIZE_NUMBER,
    private var lottoCollection: MutableList<Lotto> = mutableListOf()
) {
    fun setPay(payment: Int) {
        this.pay = payment
    }

    fun setLottoCollection(newLottoCollection: MutableList<Lotto>) {
        this.lottoCollection = newLottoCollection
    }

    fun getPay(): Int = pay

    fun getLottoCollection(): List<Lotto> = lottoCollection.toList()
}

