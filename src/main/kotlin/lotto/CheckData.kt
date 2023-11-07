import LottoData.lottoResult

object CheckData {

    private const val ERROR = "[ERROR]"
    private const val INPUT_AGAIN = "다시 입력하세요."
    private const val WRONG_FORMAT = "$ERROR 잘못된 형식입니다. $INPUT_AGAIN"
    private const val WRONG_RANGE = "$ERROR 1~45까지의 숫자 범위 안에서 허용됩니다. $INPUT_AGAIN"
    private const val DUPLICATE_ERROR = "$ERROR 중복된 숫자가 있습니다. $INPUT_AGAIN"
    private const val LOW_PRICE = "$ERROR 1000원 밑으로는 구매할 수 없습니다."
    private const val INCLUDE_STR = "$ERROR 문자열에 숫자 이외의 문자가 포함되어 있습니다."
    private const val NOT_DIVIDE_MONEY = "$ERROR 1000원 단위로 떨어지지 않습니다."
    private const val INPUT_FORMAT_RULE = "$ERROR 6개의 숫자를 ,를 기준으로 입력해주세요."

    fun checkInputMoney(inputMoney: String) {
        require(checkPrice(inputMoney)) { LOW_PRICE }
        require(checkDigitNum(inputMoney)) { INCLUDE_STR }
        require(checkDivide(inputMoney)) { NOT_DIVIDE_MONEY }
    }

    fun checkLottoNum(lottoNum: String) {
        val numbers = lottoNum.split(",")
        require(checkDigitList(numbers)) { WRONG_FORMAT }
        require(checkLottoCount(numbers)) { INPUT_FORMAT_RULE }
        require(checkLottoRange(numbers)) { WRONG_RANGE }
        require(checkDuplicateLotto(numbers)) { DUPLICATE_ERROR }
    }

    fun checkBonusNum(bonusNum: String) {
        require(checkDigitNum(bonusNum)) { WRONG_FORMAT }
        require(checkRange(bonusNum)) { WRONG_RANGE }
        require(checkDuplicateBonus(lottoResult.map { it.toString() }, bonusNum)) { DUPLICATE_ERROR }
    }

    private fun checkDuplicateLotto(list : List<String>) = list.size == list.toSet().size
    private fun checkDuplicateBonus(list : List<String> , bonus : String) = !list.contains(bonus)

    private fun checkLottoCount(numbers : List<String>) = numbers.size == 6

    private fun checkLottoRange(numbers : List<String>) = numbers.all { checkRange(it) }

    private fun checkDigitList(input : List<String>) =  input.all { it.isNumeric() }

    private fun checkDigitNum(input : String) = input.toIntOrNull() != null

    private fun checkDivide(inputMoney : String) =  Integer.parseInt(inputMoney) % 1000 == 0

    private fun checkPrice(inputMoney : String) = Integer.parseInt(inputMoney) >= 1000

    private fun checkRange(lotto : String) = Integer.parseInt(lotto) in 1..45

    private fun String.isNumeric(): Boolean {
        return this.matches("-?\\d+(\\.\\d+)?".toRegex())
    }


}