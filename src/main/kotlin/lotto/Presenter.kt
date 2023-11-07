package lotto

import camp.nextstep.edu.missionutils.Console

class Presenter(
    private val printer: Printer = Printer(),
    private val game: Game = Game()
) {

    fun execute() {

    }

    fun purchaseLottery() {
        try {

        } catch (e: IllegalArgumentException) {
            print(Message.ERROR)
            println(e)
            execute()
        }
    }

    fun createRandomLottery(){
        try {

        } catch (e: IllegalArgumentException) {
            print(Message.ERROR)
            println(e)
            execute()
        }
    }

    fun inputUserPickNumberAndBonusNumber() {
        try {
            val input = Console.readLine().trim()
        } catch (e: IllegalArgumentException) {
            print(Message.ERROR)
            println(e)
            execute()
        }
    }

    fun getLotteryWinning(){
        try {
            
        } catch (e: IllegalArgumentException) {
            print(Message.ERROR)
            println(e)
            execute()
        }
    }


}