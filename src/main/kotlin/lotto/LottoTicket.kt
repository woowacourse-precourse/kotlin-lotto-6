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
            println(Constant.PRICE_INPUT)
            try {
                price = getInput().toInt()
                inputNumberValid(price)
                return price
            } catch (e: NumberFormatException) {
                println(Constant.NUMBER_ERROR_MESSAGE)
            } catch (e: IllegalArgumentException) {
                println(Constant.PRICE_ERROR_MESSAGE)
            }
        }
    }

    private fun getInput(): String {
        return Console.readLine()
    }

    private fun inputNumberValid(price: Int) {
        if (price % 1000 != 0) {
            throw IllegalArgumentException(Constant.INPUT_ERROR)
        }
    }

    private fun getLottoTickets(price: Int): MutableList<List<Int>> {
        val totalLottoCount = price / 1000
        println("\n${totalLottoCount}${Constant.COUNT}")
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
            println(Constant.NUMBER_INPUT)
            try {
                val lottoNumberInput = Console.readLine().split(',')
                lottoNumbers = lottoNumberInput.map { it.toInt() }
                checkLottoNumbersValid(lottoNumbers)
                return lottoNumbers.sorted().toMutableList()
            } catch (e: NumberFormatException) {
                println(Constant.NUMBER_ERROR_MESSAGE)
            } catch (e: IllegalArgumentException) {
                catchErrorMessageInGetLottoNumbers(e)
            }
        }
    }

    private fun catchErrorMessageInGetLottoNumbers(e: IllegalArgumentException) {
        when (e.message) {
            Constant.DUPLICATE_ERROR -> println(Constant.DUPLICATE_ERROR_MESSAGE)
            Constant.INPUT_COUNT_ERROR -> println(Constant.INPUT_SIZE_ERROR_MESSAGE)
            Constant.INPUT_SIZE_ERROR -> println(Constant.RANGE_ERROR_MESSAGE)
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
            throw IllegalArgumentException(Constant.INPUT_SIZE_ERROR)
        }
    }

    private fun checkInputCount(lottoNumbers: List<Int>) {
        if (lottoNumbers.size != 6) {
            throw IllegalArgumentException(Constant.INPUT_COUNT_ERROR)
        }
    }

    private fun checkLottoNumbersDuplicate(lottoNumbers: List<Int>) {
        if (lottoNumbers.size != lottoNumbers.toSet().size) {
            throw IllegalArgumentException(Constant.DUPLICATE_ERROR)
        }
    }
}
