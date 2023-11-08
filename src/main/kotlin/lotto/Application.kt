package lotto

fun main() {
    startGame()
}
enum class lottoGame {
    RESULT;

    var winningCount = MutableList(5) { 0 }
    val winningProbability = MutableList(5) { 0 }

    val realLottoNumbers = mutableListOf<Int>()

    fun setRealNumber(realNumbers: List<Int>) {
        for(numbers in realNumbers)
            realLottoNumbers.add(numbers)
    }

    fun setWinnningProbability(value: Int) {
        winningProbability.add(value)
    }
}

fun startGame() {
    val playerLottoNumbers = getLottoNumbers()
    val realLottoNumbers = getRealLottoNumber()

    playGame(playerLottoNumbers, realLottoNumbers)
}

fun playGame(playerLottoNumbers: List<List<Int>>, realLottoNumbers: List<Int>) {
    lottoGame.RESULT.setRealNumber(realLottoNumbers)
    for(playerNumber in playerLottoNumbers) {
        Lotto(playerNumber).startAnaylze()
    }
    Lotto(playerLottoNumbers[0]).printResult()
}

fun getLottoNumbers(): List<List<Int>> {
    val player = Controller()

    val seedMoney = player.getSeedMoney()
    lottoGame.RESULT.setWinnningProbability(seedMoney)
    val ticketNumber = player.generateLottoNumbers(seedMoney)
    val lottoNumberResults = player.getRandomLottoNumbers(ticketNumber)
    player.printRandomLottoNumbers(lottoNumberResults)

    return lottoNumberResults
}

fun getRealLottoNumber(): List<Int> {
    val lottoManager = Controller()

    val realLottoNumbers = lottoManager.getRealLottoNumbers().sorted()
    val bonusLottoNumber = lottoManager.getBonusLottoNumber()

    return realLottoNumbers + listOf(bonusLottoNumber)
}