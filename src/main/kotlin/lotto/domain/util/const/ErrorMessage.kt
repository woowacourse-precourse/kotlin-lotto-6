package lotto.domain.util.const

object ErrorMessage {
    const val error_bonus_number = "$errorPrefix 보너스 번호는 $minLottoWinningNumber~$maxLottoWinningNumber 사이의 숫자 중 당첨 번호와 중복 되지 않는 수 하나를 입력해야 합니다."
    const val error_lotto_numbers = "$errorPrefix 당첨 번호는 $minLottoWinningNumber~$maxLottoWinningNumber 사이의 중복되지 않는 숫자를 , 로 구분하여 ${lottoWinningNumberQuantity}개를 입력해야 합니다."
    const val error_price = "$errorPrefix 구입금액은 ${lottoPrice}원 단위의 숫자 여야합니다."
    const val error_duplicated_lotto_numbers = "$errorPrefix 로또 번호는 중복이 될 수 없습니다.\""
}