package chapter1.part5

class UnionFind(nodesAmount: Int) {

    /* Элементы */
    private val id: IntArray = IntArray(nodesAmount)

    init {
        /* Заполнили элементы 1,2,3...N */
        for (i in id) {
            id[i] = i
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
        return id[oneElement] == id[anotherElement]
    }

    fun union(oneElement: Int, anotherElement: Int) {
        val oneElementRoot = root(oneElement)
        val anotherElementRoot = root(anotherElement)

        id[oneElementRoot] = anotherElementRoot
    }
}