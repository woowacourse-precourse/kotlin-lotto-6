package lotto.data

object ConstNum {

    const val Three_Lotto_Amount = 5000
    const val Four_Lotto_Amount= 50000
    const val Five_Lotto_Amount = 1500000
    const val Five_Bonus_Lotto_Amount = 30000000
    const val Six_Lotto_Amount = 2000000000


}
object ConstString {
    const val Three_Corresponding = "3개 일치"
    const val Four_Corresponding = "4개 일치"
    const val Five_Corresponding = "5개 일치"
    const val Five_Bonus_Corresponding ="5개 일치, 보너스 볼 일치"
    const val Six_Corresponding = "6개 일치"

    const val Three_Lotto_Amount = "5,000"
    const val Four_Lotto_Amount= "50,000"
    const val Five_Lotto_Amount = "1,500,000"
    const val Five_Bonus_Lotto_Amount = "30,000,000"
    const val Six_Lotto_Amount = "2,000,000,000"

}

object ErrorMessage {
    const val ERROR_LOTTO_AMOUNTS= "[ERROR] 로또 번호는 1000원 단위의 금액이어야 합니다."
    const val ERROR_LOTTO_NUM = "[ERROR] 로또 번호는 1부터 45 사이의 6가지 숫자여야 합니다."
    const val ERROR_LOTTO_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다."

}