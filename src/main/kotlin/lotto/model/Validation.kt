package lotto.model

import lotto.model.Constant.LOTTO_COST
import lotto.model.Constant.LOTTO_MAX_NUMBER
import lotto.model.Constant.LOTTO_MIN_NUMBER
import lotto.model.Constant.LOTTO_SIZE

internal fun String.isAmountInThousand() =
    require(this.toInt() % LOTTO_COST == 0) { ErrorMessage.IsNotAmountInThousand }

internal fun String.isDigit() =
    requireNotNull(this.toIntOrNull()) { ErrorMessage.IsDigit }

internal fun String.isLessThanThousand() =
    require(this.toInt() >= LOTTO_COST) { ErrorMessage.IsLessThanThousand }

internal fun List<String>.checkLottoSize() =
    require(this.size == LOTTO_SIZE) { ErrorMessage.CheckLottoSize }

internal fun String.isLottoNumber() =
    require(this.toInt() in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { ErrorMessage.IsLottoNumber }

internal fun List<String>.isDuplicateNumber() =
    require(this.distinct().size == this.size) { ErrorMessage.IsDuplicateNumber }

internal fun String.hasNoDuplicateNumbers(winNumber: List<Int>) =
    require(winNumber.contains(this.toInt()).not()) { ErrorMessage.HasNoDuplicateNumbers }

internal enum class ErrorMessage(private val message: String) {
    IsNotAmountInThousand("구입 금액은 1,000원 단위 이어야 합니다."),
    IsDigit("구입 금액은 숫자 이어야 합니다."),
    IsLessThanThousand("구입 금액은 1000원 이상 이어야 합니다."),
    CheckLottoSize("당첨 번호는 6개의 숫자 이어야 합니다."),
    IsLottoNumber("당첨 번호는 1 ~ 45 까지 숫자 이어야 합니다."),
    IsDuplicateNumber("당첨 번호는 중복이 없어야 합니다."),
    HasNoDuplicateNumbers("당첨 번호와 보너스 번호는 중복 될 수 없습니다.");

    override fun toString() = message
}

object Constant {
    const val LOTTO_COST = 1000
    const val LOTTO_MIN_NUMBER = 1
    const val LOTTO_MAX_NUMBER = 45
    const val LOTTO_SIZE = 6
}