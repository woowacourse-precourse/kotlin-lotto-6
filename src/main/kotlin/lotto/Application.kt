package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val lotto_tickets = buyLotto()
    val lotto_list = generateLottoNumbers(lotto_tickets)
    val winning_numbers_list = receiveWinningNumbers()
    val bonus_number = receiveBonusNumbers()
    val result = calculateLottoNumbers(lotto_list, winning_numbers_list, bonus_number)
    printResult(result, lotto_tickets)
}

fun buyLotto(): Int {
    println("구입금액을 입력해 주세요.")
    val price = readLine()!!.toInt()
    if (price % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 로또 구매는 1000원 단위로만 가능합니다.")
    } else if (price == null) {
        throw IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.")
    } else return price / 1000
}

fun generateLottoNumbers(lotto_tickets: Int): MutableList<MutableList<Int>> {
    println("${lotto_tickets}개를 구매했습니다.")
    val lotto_list: MutableList<MutableList<Int>> = mutableListOf()
    repeat(lotto_tickets){
        val lotto_numbers = mutableListOf<Int>()
        while (lotto_numbers.size < 6) {
            val random_numbers = Randoms.pickNumberInRange(1, 45)
            if(!lotto_numbers.contains(random_numbers)) {
                lotto_numbers.add(random_numbers)
            }
        }
        lotto_numbers.sort()
        println(lotto_numbers)
        lotto_list.add(lotto_numbers)
    }
    return lotto_list
}

fun receiveWinningNumbers(): MutableList<Int> {
    val winning_numbers_list = mutableListOf<Int>()
    println("당첨 번호를 입력해 주세요.")
    val winning_numbers = readLine().toString().split(",")
    for (numbers in winning_numbers) {
        if (numbers.toInt() < 1 || numbers.toInt() > 45 ) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        winning_numbers_list.add(numbers.toInt())
    }
    if(winning_numbers.size > 6) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력 가능 합니다.")
    }
    if(winning_numbers.size != winning_numbers.distinct().count()){
        throw IllegalArgumentException("[ERROR] 로또 번호는 중복 없이 입력해야 합니다.")
    }
    winning_numbers_list.sort()

    return winning_numbers_list
}

fun receiveBonusNumbers(): Int {
    println("보너스 번호를 입력해 주세요.")
    val bonus_number = readLine()!!.toInt()
    if (bonus_number < 1 || bonus_number > 45 ) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        receiveBonusNumbers()
    }

    return bonus_number
}

fun calculateLottoNumbers(lotto_list: MutableList<MutableList<Int>>, winning_numbers_list: MutableList<Int>, bonus_number: Int): MutableList<Int> {
    val result = MutableList(5){ 0 }
    for(lotto in lotto_list){
        val commonCount = lotto.intersect(winning_numbers_list).count()
        if(commonCount == 3){
            result[0] ++
        }else if(commonCount == 4){
            result[1] ++
        }else if(commonCount == 5){
            if(!lotto.contains(bonus_number)){
                result[2] ++
            }else result[3] ++
        }else if(commonCount == 6) {
            result[4] ++
        }
    }

    return result
}

fun printResult(result: MutableList<Int>, lotto_tickets: Int) {
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${result[0]}개")
    println("4개 일치 (50,000원) - ${result[1]}개")
    println("5개 일치 (1,500,000원) - ${result[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[3]}개")
    println("6개 일치 (2,000,000,000원) - ${result[4]}개")
    var returnRate = (5000 * result[0] + 50000 * result[1] + 1500000 * result[2] + 30000000 * result[4] + 20000000000 * result[4]).toDouble() / (lotto_tickets * 10)
    returnRate = "%.2f".format(returnRate).toDouble()

    println("총 수익률은 ${returnRate}%입니다.")
}