package lotto

class UserInput {

    fun payMoney(): Int? {

        return readLine()?.toInt()
    }

    fun getLotNum(): List<Int>? {
        return readLine()?.split(',')?.map { it.toInt() }
    }

    fun getBonusNum(): Int? {
        return readLine()?.toInt()
    }
}