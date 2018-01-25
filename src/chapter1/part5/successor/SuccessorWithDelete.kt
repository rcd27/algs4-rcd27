package chapter1.part5.successor

import java.lang.System.arraycopy

class SuccessorWithDelete(integersAmount: Int) {

    var elements = IntArray(integersAmount)

    init {
        for (i in 0 until integersAmount) {
            elements[i] = i
        }
    }

    fun delete(p: Int) {
        val newElements = IntArray(elements.size - 1)

        /* Copy before p element */
        arraycopy(elements, 0, newElements, 0, p)
        /* Copy after p element */
        arraycopy(elements, p + 1, newElements, p, newElements.size - p)

        this.elements = newElements
    }

    fun successor(p: Int): Int {
        when {
            p < elements.size - 1 -> return elements[p + 1]
            p >= elements.size - 1 -> return elements[elements.last()]
        }
        return 0
    }
}