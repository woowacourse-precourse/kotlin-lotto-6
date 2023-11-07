package lotto.domain

class LottoMC() {
    fun pickLottoNum(lottoNum: String): List<Int> {
        val numbers = lottoNum.split(",").map { it.trim().toInt() }

        validateLottoNumbers(numbers)

        return numbers
    }

    fun pickBonusNum(bonusNum: String, lottoNum: List<Int>): String {

        validateBonusNumber(bonusNum, lottoNum)

        return bonusNum
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        require(numbers.isNotEmpty()) { "[ERROR] 로또 당첨 번호 6개를 필수로 입력해야 합니다." }
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개로만 입력해야 합니다." }
        for (num in numbers) {
            require(num in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        }
        require(numbers.size == numbers.distinct().count()) { "[ERROR] 로또 당첨 번호는 중복되지 않아야 합니다." }
    }

    private fun validateBonusNumber(bonusNum: String, lottoNum: List<Int>) {
        require(bonusNum.isNotBlank()) { "[ERROR] 로또 보너스 번호 1개를 필수로 입력해야 합니다." }
        require(bonusNum.toInt() in 1..45) { "[ERROR] 로또 보너스 번호는 1부터 45 사이 숫자여야 합니다." }
        require(bonusNum.toInt() !in lottoNum) { "[ERROR] 로또 보너스 번호는 당첨 번호와 중복되지 않아야 합니다." }
    }
}