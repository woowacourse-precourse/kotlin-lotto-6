package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val lotto_tickets = buyLotto()
    val lotto_list = generateLottoNumbers(lotto_tickets)
    val (winning_numbers_list, bonus_number) = receiveWinningNumbers()
    val result = calculateLottoNumbers(lotto_list, winning_numbers_list, bonus_number)
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

fun receiveWinningNumbers(): Pair<MutableList<Int>, Int> {
    val winning_numbers_list = mutableListOf<Int>()
    println("당첨 번호를 입력해 주세요.")
    val winning_numbers = readLine().toString().split(",")
    for (numbers in winning_numbers) {
        winning_numbers_list.add(numbers.toInt())
    }
    winning_numbers_list.sort()
    println("보너스 번호를 입력해 주세요.")
    val bonus_number = readLine()!!.toInt()

    return Pair(winning_numbers_list, bonus_number)
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