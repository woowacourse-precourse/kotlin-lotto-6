package lotto.util

object Validation {

    fun validatePurchaseAmount(amount: String) {

        require(amount.isNotEmpty())
        { "[ERROR] 구매 금액을 입력해주세요." }

        require(amount.toIntOrNull() != null)
        { "[ERROR] 숫자만 입력 가능합니다." }

        require((amount.toInt() % 1000 == 0) && (amount.toInt() > 0))
        { "[ERROR] 금액은 1,000원 단위로만 입력 가능합니다." }

    }

    fun validateDuplicateNumbers(lottoNumbers: List<Int>): Boolean {

        val lottoCheck = HashSet<Int>()
        for (number in lottoNumbers) {
            if (lottoCheck.contains(number)) {
                return true
            }
            lottoCheck.add(number)
        }
        return false
    }

    fun validateWinningNumbers(winningNumbers: List<String>) {

        require(winningNumbers.all { it.toIntOrNull() != null })
        { "[ERROR] 로또 번호로 숫자를 입력해주세요." }

        require(winningNumbers.size == 6)
        { "[ERROR] 로또 번호는 6개의 숫자입니다." }

        require(winningNumbers.all { it.toInt() in 1..45 })
        { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }

        require(!validateDuplicateNumbers(winningNumbers.map { it.toInt() }))
        { "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다." }
    }

    fun validateBonusNumber(winningNumbers: List<Int>, bonusNumber: String) {
        require(bonusNumber.toIntOrNull() != null)
        { "[ERROR] 보너스 번호로 숫자를 입력해주세요." }

        require(bonusNumber.toInt() in 1..45)
        { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }

        require(!winningNumbers.contains(bonusNumber.toInt()))
        { "[ERROR] 로또 번호와 중복되는 번호입니다." }
    }

}