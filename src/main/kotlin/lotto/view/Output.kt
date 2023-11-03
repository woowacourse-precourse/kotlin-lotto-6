package lotto.view


import lotto.model.Constants

class Output {
    fun printMoney() {
        println(Constants.WRITE_MONEY)
    }

    fun printPurchase(purchaseNumber: Int) {
        println(purchaseNumber.toString()+Constants.PURCHASE_NUMBER)
    }

}