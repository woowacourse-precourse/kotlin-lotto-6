package utils

import lotto.LottoMachine.Companion.WON_PER_LOTTO

fun createErrMsg(message: String): String = "[ERROR] $message"

fun getInvalidAmountErrMsg(): String =
    "로또의 구입 금액 단위는 ${String.format("%,d", WON_PER_LOTTO)}원 입니다."