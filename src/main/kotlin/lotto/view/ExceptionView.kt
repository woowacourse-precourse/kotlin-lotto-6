package lotto.view

object ExceptionView {
  fun printExceptionMessage(e: IllegalArgumentException) {
    println(e.message)
  }
}