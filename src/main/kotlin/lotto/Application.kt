package lotto
import camp.nextstep.edu.missionutils.Randoms

fun generateNumbers(lottoChance: Int): MutableList<List<Int>> =
    MutableList(lottoChance) { Randoms.pickUniqueNumbersInRange(1, 45, 6) }


@Suppress("UNCHECKED_CAST")
fun main() {


    val inputHandler = InputHandler()
    val purchaseAmount = inputHandler.getUserInputHandler(UserPrompt.PURCHASE_AMOUNT) as Int
    val lottoChance = purchaseAmount / 1000


    println("\n${lottoChance}개를 구매했습니다.")
    val number: MutableList<List<Int>> = generateNumbers(lottoChance)
    number.forEach { println(it.sorted()) }


    val lottoNumbers = inputHandler.getUserInputHandler(UserPrompt.LOTTO_NUMBERS) as List<Int>
    val bonusNumber = inputHandler.getUserInputHandler(UserPrompt.BONUS_NUMBER, lottoNumbers) as Int


    val lotto = Lotto(lottoNumbers)
    println("\n당첨 통계")
    println("---")
    lotto.run(number, bonusNumber, purchaseAmount)


}

