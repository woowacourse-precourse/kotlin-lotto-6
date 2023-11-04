package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.internal.Characters
import kotlin.math.round


fun main() {
    println("구입금액을 입력해 주세요.")
    val buy = Console.readLine().toInt()

    val case = buy/1000

    println("\n${case}개를 구매했습니다.")

    var buy_lotto_number = Array<Array<Int>>(case){Array<Int>(6){ 0 } }

    for(i in 1..case){
        var number = Randoms.pickUniqueNumbersInRange(1,45,6)
        for(j in 1..6){
            buy_lotto_number[i-1][j-1] = number.get(j-1)
        }

        buy_lotto_number[i-1].sort()
    }

    for(i in 1..case){
        print("[")
        for(j in 1..5){
            print("${buy_lotto_number[i-1][j-1]}, ")
        }
        println("${buy_lotto_number[i-1][5]}]")
    }

    println("\n당첨 번호를 입력해 주세요.")
    var win_number = Console.readLine().split(",")

    println("\n보너스 번호를 입력해 주세요.")
    win_number = win_number + Console.readLine()

    var result = IntArray(5)

    for(i in 0..case-1){
        var count = 0

        var str = ArrayList<Int>()

        for(j in 0..5){
            if(buy_lotto_number[i][j].equals(win_number.get(j).toInt())){
                str.add(win_number.get(j).toInt())
                count++
            }
        }

        if(buy_lotto_number[i][5].equals(win_number.get(6).toInt()) && count == 5){
            str.add(win_number.get(6).toInt())
        }


        if(count >= 3){
            if(count == 5) {
                if (str.contains(win_number.get(6).toInt())) {
                    count++
                }
            }else if(count == 6){
                count++
            }
            result[count-3] += 1
        }
    }

    println("\n당첨 통계\n---")

    var sum : Double = 0.0
    for(i in 1..5){

        when(i){
            1 -> {print("3개 일치 (5,000원) - ${result[0]}개\n")
                    if(!(result[0] == 0)){
                        sum += 5000
                    }
                }
            2 -> {print("4개 일치 (50,000원) - ${result[1]}개\n")
                    if(!(result[1] == 0)){
                        sum += 50000
                    }
                }
            3 -> {print("5개 일치 (1,500,000원) - ${result[2]}개\n")
                    if(!(result[2] == 0)){
                        sum += 1500000
                    }
                }
            4 -> {print("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[3]}개\n")
                    if(!(result[3] == 0)){
                        sum += 30000000
                    }
                }
            5 -> {print("6개 일치 (2,000,000,000원) - ${result[4]}개\n")
                    if(!(result[4] == 0)){
                        sum += 2000000000
                    }
                }
        }
    }

    sum = ((sum/buy) * 100)
    val sum_string = String.format("%.1f",sum)

    println("총 수익률은 ${sum_string}%입니다.")
}
