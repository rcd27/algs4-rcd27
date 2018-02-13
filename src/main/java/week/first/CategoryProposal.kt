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
    println(proposeCategory(20, t))
}

fun proposeCategory(price: Int, t: ArrayList<Category>): Category {
    // Я эту штуку назвал молярной массой.
    // Идея: придать вес той или иной категории.
    var mol = 0f
    t.forEach {
        mol += it.freq
    }
    mol /= t.size

    val delta = FloatArray(t.size)
    for (i in 0 until delta.size) {
        val currentCat = t[i]
        // Тут формула, составленная империческим путём, иначе говоря, методом тыка.
        val currentDelta = Math.abs(price.minus(currentCat.avaragePrice))
                .times(mol * currentCat.freq)
        delta[i] = currentDelta
    }
    val minDeltaIndex = delta.indexOf(delta.min()!!)

    return t[minDeltaIndex]
}