package utils

import lotto.LottoMachine.Companion.WON_PER_LOTTO

fun createErrMsg(message: String): String = "[ERROR] $message"

fun getInvalidAmountErrMsg(): String =
    "로또의 구입 금액 단위는 ${String.format("%,d", WON_PER_LOTTO)}원 입니다."

fun getInvalidRangeLottoNumErrMsg(start: Int, end: Int): String =
    "로또 번호는 ${start}부터 $end 사이의 숫자여야 합니다."

fun getInvalidNumbersCountErrMsg(count: Int): String =
    "${count}개의 로또 번호를 입력해주세요."