package chapter1.part5

class UnionFind(nodesAmount: Int) {
    /**
     *  В реализации этого алгоритма я бы отметил структуру
     *  хранения данных. Так как использована quick-find data structure,
     *  т.е. id элемента = id в массиве, фиксированное число,
     *  то для добавления параметра типа size создаётся массив такой
     *  же длины и заполняется единицами. Основной упор именно на
     *  структуру данных.
     */

    /* Компоненты */
    private val id: IntArray = IntArray(nodesAmount)
    /* Хранит размер компонентов*/
    private val sz: IntArray = IntArray(nodesAmount)

    init {
        /* Заполнили элементы 1,2,3...N */
        for (i in id) {
            id[i] = i
        }
        /* По дефолту, размер деревьев = 1 */
        for (i in sz) {
            sz[i] = 1
        }
    }

    private fun root(element: Int): Int {
        var root = element
        /* Поднимается по дереву */
        while (root != id[root]) {
            root = id[root]
        }
        return root
    }

    fun connected(oneElement: Int, anotherElement: Int): Boolean {
        return root(oneElement) == root(anotherElement)
    }

    fun union(p: Int, q: Int) {
        val i = root(p) // корень для p
        val j = root(q) // корень для q

        if (i == j) return

        if (sz[i] < sz[j]) { // если размер корня p < размера корня q
            id[i] = j
            sz[j] += sz[i]
        } else {             // если размер корня p >= размер корня q
            id[j] = i
            sz[i] += sz[j]
        }
    }
}