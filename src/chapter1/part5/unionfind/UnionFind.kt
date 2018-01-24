package chapter1.part5.unionfind

open class UnionFind(nodesAmount: Int) {
    /**
     *  В реализации этого алгоритма я бы отметил структуру
     *  хранения данных. Так как использована quick-find data structure,
     *  т.е. elements элемента = elements в массиве, фиксированное число,
     *  то для добавления параметра типа size создаётся массив такой
     *  же длины и заполняется единицами. Основной упор именно на
     *  структуру данных.
     */

    /* Компоненты */
    internal val elements: IntArray = IntArray(nodesAmount)
    /* Хранит размер компонентов (деревьев в частности) */
    private val sizes: IntArray = IntArray(nodesAmount)

    init {
        /* Заполнили элементы 0,1,2...N-1 */
        for (i in 0 until nodesAmount) { // FIXME: java-code
            elements[i] = i
        }

        /* По дефолту, размер деревьев = 1 */
        for (i in 0 until nodesAmount) {
            sizes[i] = 1
        }
    }

    fun root(element: Int): Int {
        var root = element
        /* Поднимается по дереву */
        while (root != elements[root]) {
            root = elements[root]
        }
        return root
    }

    fun connected(oneElement: Int, anotherElement: Int): Boolean {
        return root(oneElement) == root(anotherElement)
    }

    open fun union(p: Int, q: Int) {
        val pRoot = root(p) // корень для p
        val qRoot = root(q) // корень для q

        if (pRoot == qRoot) return

        if (sizes[pRoot] < sizes[qRoot]) {  // если размер дерева p < размера дерева q
            elements[pRoot] = qRoot         // привязываем корень p к корню q
            sizes[qRoot] += sizes[pRoot]    // размер корня q соотв. увеличивается
        } else {                            // если размер дерева p >= размера дерева q
            elements[qRoot] = pRoot         // наоборот
            sizes[pRoot] += sizes[qRoot]
        }
    }
}