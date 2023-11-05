package ui

import util.Constants.MSG_OUTPUT_PURCHASE_RESULT

object UserOutput {
    fun printPurchaseResult(count: Int) = println("$count" + MSG_OUTPUT_PURCHASE_RESULT)
}