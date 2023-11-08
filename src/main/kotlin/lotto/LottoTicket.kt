package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoTicket {

    fun getLottoListAndPrice(): Pair<MutableList<List<Int>>, Int> {
        val price = getPrice()
        val lottoList =getLottoTickets(price)
        return Pair(lottoList, price)
    }

    private fun getPrice(): Int {
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

    private fun getLottoTickets(price: Int): MutableList<List<Int>> {
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

    fun getLottoNumbers(): MutableList<Int> {
        var lottoNumbers: List<Int>
        while (true) {
            println("\n당첨번호를 입력해 주세요.")
            try {
                val lottoNumberInput = Console.readLine().split(',')
                lottoNumbers = lottoNumberInput.map { it.toInt() }
                checkLottoNumbersValid(lottoNumbers)
                return lottoNumbers.sorted().toMutableList()
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자를 써주세요!!")
            } catch (e: IllegalArgumentException) {
                catchErrorMessageInGetLottoNumbers(e)
            }
        }
    }

    private fun catchErrorMessageInGetLottoNumbers(e: IllegalArgumentException) {
        when (e.message) {
            "중복 숫자 오류" -> println("[ERROR] 중복된 숫자를 쓰지마세요")
            "입력 개수 오류" -> println("[ERROR] 입력 번호는 6개만 써주세요")
            "입력 범위 오류" -> println("[ERROR] 1 ~ 45 사이에 숫자만 써주세요")
        }
    }

    private fun checkLottoNumbersValid(lottoNumbers: List<Int>) {
        checkLottoNumbersDuplicate(lottoNumbers)
        checkInputCount(lottoNumbers)
        checkLottoLength(lottoNumbers)
    }

    private fun checkLottoLength(lottoNumbers: List<Int>) {
        for (lotto in lottoNumbers) {
            checkLength(lotto)
        }
    }

    private fun checkLength(checkLengthNumber: Int) {
        if (checkLengthNumber !in 1..45) {
            throw IllegalArgumentException("입력 범위 오류")
        }
    }

    private fun checkInputCount(lottoNumbers: List<Int>) {
        if (lottoNumbers.size != 6) {
            throw IllegalArgumentException("입력 개수 오류")
        }
    }

    private fun checkLottoNumbersDuplicate(lottoNumbers: List<Int>) {
        if (lottoNumbers.size != lottoNumbers.toSet().size) {
            throw IllegalArgumentException("중복 숫자 오류")
        }
    }
}
