package lotto

class UserInput {

    fun payMoney(): Int? {

        return readLine()?.toInt()
    }

    fun getLotNum(): List<String>? {

        return readLine()?.split(',')
    }

    fun getBonusNum(): Int? {
        return readLine()?.toInt()
    }
}