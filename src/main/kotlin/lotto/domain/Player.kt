package lotto.domain

class Player(private var money: Int) {

    fun purchaseLotto(): List<Lotto> {
        val boughtLotto = NumberIssuer.issueNumbers(money)
        return boughtLotto
    }

    fun getReturnMoney(returnMoney: Int) {
        money += returnMoney
    }

}