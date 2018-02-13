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
    println(proposeCategory(1500, t))
}

// FIXME: работает для Travel, Sigarretes и не работает для Category
fun proposeCategory(price: Int, t: ArrayList<Category>): Category {
    var mol = 0f
    t.forEach {
        mol += it.freq
    }
    mol /= t.size

    val delta = FloatArray(t.size)
    for (i in 0 until delta.size) {
        val currentCat = t[i]
        val currentDelta = Math.abs(price.minus(currentCat.avaragePrice))
                .div(currentCat.freq / mol)
        delta[i] = currentDelta
    }
    val minDeltaIndex = delta.indexOf(delta.min()!!)

    return t[minDeltaIndex]
}