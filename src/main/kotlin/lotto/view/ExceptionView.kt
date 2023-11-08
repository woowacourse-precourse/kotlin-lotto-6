package lotto.view

object ExceptionView {
  fun printPurchaseMoneyExceptionMessage(e: IllegalArgumentException) {
    println(e.message)
  }
}