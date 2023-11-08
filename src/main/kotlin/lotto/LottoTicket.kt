package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoTicket {

    fun getPrice(): Int {
        return retrieveValidPrice()
    }

    private fun retrieveValidPrice(): Int {
        var price: Int
        while (true) {
            println("구입금액을 입력해 주세요.")
            try {
                price = getInput().toInt()
                inputNumberValid(price)
                return price
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자를 입력하세요!!")
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 구매 금액은 1,000원 단위 입니다!!")
            }
        }
    }

    private fun getInput(): String {
        return Console.readLine()
    }

    private fun inputNumberValid(price: Int) {
        if (price % 1000 != 0) {
            throw IllegalArgumentException("입력 오류")
        }
    }

    fun getLottoTickets(price: Int): MutableList<List<Int>> {
        val totalLottoCount = price / 1000
        println("\n${totalLottoCount}개를 구매했습니다.")
        val lottoList = mutableListOf<List<Int>>()
        for (i in 0 until totalLottoCount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 7).sorted()
            lottoList.add(lottoNumber)
            val printLottoNumber = lottoNumber.subList(0, 6)
            println(printLottoNumber)
        }
        return lottoList
    }
}
