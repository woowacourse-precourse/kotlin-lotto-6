package lotto.domain

class Player(private var money: Int) {

    fun purchaseLotto(): List<Lotto> {
        val lottoNumbers = mutableListOf<Lotto>()
        val quantity = money / 1000
        repeat(quantity) {
            val numbers = Lotto(NumberIssuer.issueNumbers())
            lottoNumbers.add(numbers)
        }
        return lottoNumbers
    }

    fun getReturnMoney(returnMoney: Int) {
        money += returnMoney
    }

}