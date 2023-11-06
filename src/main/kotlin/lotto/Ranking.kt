package lotto

enum class Ranking(val match: Int, val rank: Int) {
    Five(3, 5),
    Four(4, 4),
    Three(5, 3),
    Two(6, 2),
    One(7, 1);

    companion object{
        private val ranking = IntArray(8)
        private var prize = 0
        private val array = enumValues<Ranking>()

        fun check(match: Int, bonus: Int) {
            if(bonus == 0){
                array.filter { it.match == match }
                ranking[match]++
            }
            else { //2등
                ranking[match+1]++
            }
        }
        fun getRank(): IntArray {
            return ranking
        }
    }


}