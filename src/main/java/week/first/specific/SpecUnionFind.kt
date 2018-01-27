package week.first.specific

import week.first.unionfind.UnionFind

class SpecUnionFind(nodesAmount: Int) : UnionFind(nodesAmount) {

    private val max = IntArray(nodesAmount)

    init {
        for (i in 0 until nodesAmount) {
            max[i] = i
        }
    }

    override fun union(p: Int, q: Int) {
        super.union(p, q)

        val maxP = max(p)
        val maxQ = max(q)

        if (max[maxP] < max[maxQ]) {
            changeMax(maxP, maxQ)
        } else {
            changeMax(maxQ, maxP)
        }
    }

    private fun changeMax(maxP: Int, maxQ: Int) {
        max[maxP] = max[maxQ]
    }

    fun max(p: Int): Int {
        var maximum = p
        while (maximum != max[maximum]) {
            maximum = max[maximum]
        }
        return maximum
    }
}