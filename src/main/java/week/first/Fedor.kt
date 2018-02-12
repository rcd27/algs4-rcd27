package week.first

import java.util.*

open class Category(val freq: Int, val avaragePrice: Int)

object Travel : Category(freq = 10, avaragePrice = 20)
object Sigarettes : Category(freq = 5, avaragePrice = 80)
object Electronics : Category(freq = 1, avaragePrice = 1000)

fun main(args: Array<String>) {
    val t = arrayListOf(Sigarettes, Electronics, Travel)
    // Сортировка по убыванию частоты использования
    t.sortByDescending { category: Category -> category.freq }
    proposeCategory(50, t) // должно выдать Travel, так как дельта одинаковая, но Travel чаще встречается
}

fun proposeCategory(price: Int, t: ArrayList<Category>): Category {

    val delta = IntArray(t.size)
    for (i in 0 until delta.size) {
        val currentCat = t.get(i)
        // TODO: расчитать дельту и выдать результат на её основании
    }
    return Travel
}